public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');
    }

    static void towerOfHanoi(int disks, char from, char to, char aux) {
        if (disks == 1) {
            System.out.println("Moving disk 1 from :" + from + " to:" + to);
            return;
        }
        towerOfHanoi(disks - 1, from, aux, to);
        System.out.println("Moving disk" + (disks - 1) + "from :" + from + " to:" + to);
        towerOfHanoi(disks - 1, aux, to, from);
    }
}
