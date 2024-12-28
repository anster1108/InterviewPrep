/*
	Shortest Job First
		A software engineer is tasked with using the shortest job first (SJF) policy to calculate the average waiting time for each process. The shortest job first also known as shortest job next (SJN) scheduling policy selects the waiting process with the least execution time to run next.

		Given an array of n integers representing the burst times of processes, determine the average waiting time for all processes and return the closest whole number that is less than or equal to the result.

	Example 1
		Input : bt = [4, 1, 3, 7, 2]
		Output : 4
		Explanation : The total waiting time is 20.
		So the average waiting time will be 20/5 => 4.

	Example 2
		Input : bt = [1, 2, 3, 4]
		Output : 2
		Explanation : The total waiting time is 10.
		So the average waiting time will be 10/4 => 2.

	Example 3
		Input : bt = [9, 3, 1, 8, 2]
		Output: 4

	Solution :
		Intuition :
			The Shortest Job First (SJF) algorithm will be used to solve this problem. First, the job durations are sorted from shortest to longest to ensure the shortest job is handled next. After sorting, each job is processed in sequence, and the waiting time for each job is calculated by summing the durations of all previous jobs. This accumulated waiting time is then used to determine the total waiting time for all jobs.
		Approach
			- Begin by sorting the job durations in ascending order so that the jobs are arranged from shortest to longest.
			- Initialize counters to keep track of the waiting time for each job and the total waiting time for all jobs.
			- Iterate through the sorted list of jobs. For each job, calculate its waiting time by summing the durations of all the previous jobs. Add the duration of the current job to the cumulative total time.
			- Once all jobs have been processed, calculate the average waiting time by dividing the total waiting time by the number of jobs.


	Complexity Analysis
		Time Complexity: O(N logN + N) where N is the length of the jobs array.The code first sorts the job durations, which takes O(N logN) time. After sorting, it iterates through the job durations to calculate the total waiting time, which takes O(N) time.
	
		Space Complexity: O(1) no extra space used.
*/
import java.util.*;

class ShortestJobFirst {
    /* Function to calculate total waiting 
       time using Shortest Job First algorithm */
    public long solve(int[] bt) {
        // Sort jobs in ascending order
        Arrays.sort(bt);

        // Initialize total waiting time
        long waitTime = 0;
        // Initialize total time taken
        long totalTime = 0;
        // Get number of jobs
        int n = bt.length;

        // Iterate to calculate waiting time
        for (int i = 0; i < n; ++i) {
            waitTime += totalTime;
            totalTime += bt[i];
        }

        // Return average waiting time
        return waitTime / n;
    }

    public static void main(String[] args) {
        int[] jobs = {1, 2, 3, 4};

        System.out.print("Array Representing Job Durations: ");
        for (int job : jobs) {
            System.out.print(job + " ");
        }
        System.out.println();

        ShortestJobFirst ShortestJobFirst = new ShortestJobFirst();
        long ans = ShortestJobFirst.solve(jobs);
        System.out.println("Total waiting time: " + ans);
    }
}