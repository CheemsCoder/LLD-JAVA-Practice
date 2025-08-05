package org.example.UniqueIDGenerator;

import java.util.concurrent.locks.ReentrantLock;

public class UniqueIdGenerator {

    // =================== Configuration ===================
    private final long EPOCH = 1622505600000L; // Custom epoch (e.g. June 1, 2021)

    private final long machineIdBits = 10L;      // Number of bits for machine ID (max 1024 machines)
    private final long maxMachineId = ~(-1L << machineIdBits); // Max machine ID

    private final long sequenceBits = 12L;       // Number of bits for sequence (max 4096 IDs per millisecond)
    private final long maxSequence = ~(-1L << sequenceBits);

    private final long machineIdShift = sequenceBits;               // Machine ID shift
    private final long timestampLeftShift = sequenceBits + machineIdBits; // Timestamp shift

    // =================== Instance Variables ===================
    private final long machineId; // Unique machine ID
    private long lastTimestamp = -1L;
    private long sequence = 0L;

    private final ReentrantLock lock = new ReentrantLock(); // To ensure thread safety

    // =================== Constructor ===================
    public UniqueIdGenerator(long machineId) {
        if (machineId > maxMachineId || machineId < 0) {
            throw new IllegalArgumentException(String.format("Machine ID must be between 0 and %d", maxMachineId));
        }
        this.machineId = machineId;
    }

    // =================== ID Generation Method ===================
    public long nextId() {
        lock.lock();
        try {
            long timestamp = currentTimeMillis();

            if (timestamp < lastTimestamp) {
                throw new RuntimeException("Clock moved backwards. Refusing to generate ID.");
            }

            if (timestamp == lastTimestamp) {
                // Same millisecond -> increment sequence
                sequence = (sequence + 1) & maxSequence;
                if (sequence == 0) {
                    // Sequence exhausted in the current millisecond, wait for next millisecond
                    timestamp = waitNextMillis(timestamp);
                }
            } else {
                // New millisecond -> reset sequence
                sequence = 0L;
            }

            lastTimestamp = timestamp;

            // Build ID
            return ((timestamp - EPOCH) << timestampLeftShift) | (machineId << machineIdShift) | sequence;
        } finally {
            lock.unlock();
        }
    }

    // =================== Helper Methods ===================
    private long waitNextMillis(long currentMillis) {
        long timestamp = currentTimeMillis();
        while (timestamp <= currentMillis) {
            timestamp = currentTimeMillis();
        }
        return timestamp;
    }

    private long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    // =================== Example Usage ===================
    public static void main(String[] args) {
        UniqueIdGenerator generator = new UniqueIdGenerator(1); // Assuming machine ID = 1

        for (int i = 0; i < 10; i++) {
            System.out.println(generator.nextId());
        }
    }
}

