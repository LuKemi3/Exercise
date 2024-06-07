public class exe04 {
    static int[][] allocation = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 }, { 2, 1, 1 }, { 0, 0, 2 } };
    static int[][] max = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 }, { 4, 3, 3 } };
    static int[][] need = { { 7, 4, 3 }, { 1, 2, 2 }, { 6, 0, 0 }, { 0, 1, 1 }, { 4, 3, 1 } };
    static int[] available = { 3, 3, 2 };
    static int[] request = { 1, 0, 2 };//process why
    static int numProcesses = 5;
    static int numResources = 3;

    public static void main(String[] args) {
        int processNumber = 2;
        if (requestResources(processNumber, request)) {
            System.out.println("Request can be granted.");
        } else {
            System.out.println("Request cannot be granted.");
        }
    }

    public static boolean requestResources(int processNumber, int[] request) {

        for (int i = 0; i < numResources; i++) {
            if (request[i] > need[processNumber][i]) {
                System.out.println("Error: Process has exceeded its maximum claim.");
                return false;
            }
        }

        for (int i = 0; i < numResources; i++) {
            if (request[i] > available[i]) {
                System.out.println("Resources are not available.");
                return false;
            }
        }

        // Pretend to allocate the requested resources
        for (int i = 0; i < numResources; i++) {
            available[i] -= request[i];
            allocation[processNumber][i] += request[i];
            need[processNumber][i] -= request[i];
        }

        // Check if the system is in a safe state
        if (checkSafe()) {
            return true;
        } else {
            // Rollback if not safe
            for (int i = 0; i < numResources; i++) {
                available[i] += request[i];
                allocation[processNumber][i] -= request[i];
                need[processNumber][i] += request[i];
            }
            return false;
        }
    }

    public static boolean checkSafe() {
        int[] work = new int[numResources];
        boolean[] finish = new boolean[numProcesses];

        for (int i = 0; i < numResources; i++) {
            work[i] = available[i];
        }

        while (true) {
            boolean found = false;
            for (int i = 0; i < numProcesses; i++) {
                if (!finish[i]) {
                    boolean canAllocate = true;
                    for (int j = 0; j < numResources; j++) {
                        if (need[i][j] > work[j]) {
                            canAllocate = false;
                            break;
                        }
                    }

                    if (canAllocate) {
                        for (int j = 0; j < numResources; j++) {
                            work[j] += allocation[i][j];
                        }
                        finish[i] = true;
                        found = true;
                    }
                }
            }

            if (!found) {
                break;
            }
        }

        for (int i = 0; i < numProcesses; i++) {
            if (!finish[i]) {
                return false;
            }
        }

        return true;
    }
}
