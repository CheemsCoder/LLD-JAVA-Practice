package org.example.VotingSystem;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {
    private static VoteManager instance;
    Integer id;
    Map<Integer, Voter> voters;
    Map<Integer, Candidate> candidates;
    Map<Integer, Integer> voteCount;
    Map<Integer, Integer> votes;
    private VoteManager(Integer id) {
        this.id = id;
        voters = new HashMap<>();
        candidates = new HashMap<>();
        votes = new HashMap<>();
        voteCount = new HashMap<>();
    }
    public static VoteManager getInstance() {
       if(instance == null) {
           instance = new VoteManager(null);
       }
       return instance;
    }

    public Voter addVoter(Integer id, String name) {
        Voter voter = new Voter(id, name);
        voters.put(id, voter);
        return voter;
    }

    public Candidate addCandidate(Integer id, String name) {
        Candidate candidate = new Candidate(id, name);
        candidates.put(id, candidate);
        return candidate;
    }

    public void castVote(Voter voter, Candidate candidate) {
        if(votes.containsKey(voter.id)) {
            System.out.println("Voter has already voted");
            return;
        }
        Integer vc = voteCount.getOrDefault(candidate.getId(), 0);
        vc++;
        voteCount.put(candidate.getId(), vc);
    }

    public void showResult() {
        System.out.println(voteCount.toString());
    }
}
