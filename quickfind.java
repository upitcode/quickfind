package quickfinduf;

/**
 *
 * @author imdad
 */
public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int a, int b) {
        return id[a] == id[b];
    }

    public void union(int a, int b) {
        System.out.println("union(" + a + "," + b + ")");//union operation of a and b
        printID();//id[] before union operation

        if (!connected(a, b)) {
            int aid = id[a];
            int bid = id[b];

            for (int i = 0; i < id.length; i++) {
                if (id[i] == aid) {
                    id[i] = bid;
                }
            }
        }
        printID();//id[] changed after union operation
    }

    private void printID() {//Method to see state of  datastructure id[]
        System.out.print(id[0]);
        for (int i = 1; i < id.length; i++) {
            System.out.print(" " + id[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        QuickFindUF obj = new QuickFindUF(10);

        obj.union(4, 3);
        //obj.printID();

        obj.union(3, 8);
        obj.union(6, 5);
        obj.union(9, 4);
        obj.union(2, 1);

        System.out.println(obj.connected(8, 9) ?
                "8 and 9 are connected" :
                "8 and 9 are not connected");
        System.out.println(obj.connected(5, 0) ? 
                "5 and 0 are connected" : 
                "5 and 0 are not connected");

        obj.union(5, 0);
        obj.union(7, 2);
        obj.union(6, 1);



    }
}