package org.example.VotingSystem;

/*
Voter Registration: The system manages a list of eligible voters.
Candidate Registration: The system manages a list of candidates.
Vote Casting: Each voter can cast a vote for a candidate, but only once.
Vote Recording: The system records each vote and prevents duplicate voting.
Result Tallying: The system can tally votes for each candidate and display the results.
Extensibility: Easy to add new features such as multiple elections, voting rounds, or different voting methods.


class
voter
candidate
voteManager
 */

public class Main {
    public static void main(String[] args) {
        VoteManager voteManager = VoteManager.getInstance();
        Voter[] voters = new Voter[10];
        Candidate[] candidates = new Candidate[3];
        // Add voters
        for (int i = 0; i < 10; i++) {
            voters[i] = voteManager.addVoter(i + 1, "v" + (i + 1));
        }
        // Add candidates
        for (int i = 0; i < 3; i++) {
            candidates[i] = voteManager.addCandidate(i + 1, "c" + (i + 1));
        }
        // Cast votes
        for (int i = 0; i < 10; i++) {
            voteManager.castVote(voters[i], candidates[i % 3]);
        }
        // Show results
        voteManager.showResult();
    }
}
