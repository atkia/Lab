import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BVC {
    int p;
    int[]min = new int[10];
    int[]max = new int[10];
    int[]nom = new int[10];
    int[]NOM = new int[10];
    int[][]worst = new int[10][5];

    public BVC(int n,int []minimum,int []maximum) {
        p=n;
        for(int i=0; i<min.length; i++)
        {
            min[i]=minimum[i];
            max[i]=maximum[i];
        }
    }

    public void nominalValue(){

        for(int i=0;i<p;i++){
            nom[i] = (min[i] + max[i]) / 2;
        }
    }

    public void BVCFunction() throws IOException {
        int i = 1;
        String str = "TestCaseID,";
        for (int x = 0; x < p; x++) {
            str = str + "parameter" + String.valueOf(x + 1) + ",";
        }
        str = str + "expectedValue" + "\n";
        nominalValue();
        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(min[j]) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str + String.valueOf(nom[k]) + ",";
            }
            str = str + "\n";

            i++;
        }
        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(max[j]) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }

                str = str + String.valueOf(nom[k]) + ",";
            }

            str = str + "\n";
            i++;
        }
        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(min[j] + 1) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str + String.valueOf(nom[k]) + ",";
            }
            str = str + "\n";
            i++;
        }

        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(max[j] - 1) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str + String.valueOf(nom[k]) + ",";
            }
            str = str + "\n";
            i++;
        }
        str = str + String.valueOf(i) + ",";
        for (int k = 0; k < p; k++) {
            str = str + String.valueOf(nom[k]) + ",";
        }
        str = str + "\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Output/BVC.csv")));
        writer.write(str);

        writer.close();
    }
    public void robust() throws IOException {
        int i = 1;
        String str = "TestCaseID,";

        for (int x = 0; x < p; x++) {
            str = str + "parameter" + String.valueOf(x + 1) + ",";
        }
        str = str + "expectedValue" + "\n";
        nominalValue();
        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(min[j]) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str + String.valueOf(nom[k]) + ",";
            }
            str = str + "\n";
            i++;
        }
        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(max[j]) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str + String.valueOf(nom[k]) + ",";
            }
            str = str + "\n";
            i++;
        }
        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(min[j] + 1) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str + String.valueOf(nom[k]) + ",";
            }
            str = str + "\n";
            i++;
        }

        for (int j = 0; j < p; j++) {
            str = str + String.valueOf(i) + "," + String.valueOf(max[j] - 1) + ",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str + String.valueOf(nom[k]) + ",";
            }
            str = str + "\n";
            i++;
        }
        str = str + String.valueOf(i) + ",";
        for (int k = 0; k < p; k++) {
            str = str + String.valueOf(nom[k]) + ",";
        }
        str = str + "\n";

        i = i+1;
        for (int j = 0; j < p; j++) {
            str = str+ String.valueOf(i) +","+String.valueOf(min[j]-1)+",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str+ String.valueOf(nom[k])+",";
            }
            str = str+"\n";
            i++;
        }
        for (int j = 0; j < p; j++) {
            str = str+ String.valueOf(i) +","+String.valueOf(max[j]+1)+",";
            for (int k = 0; k < p; k++) {
                if (k == j) {
                    continue;
                }
                str = str+ String.valueOf(nom[k])+",";
            }
            str = str+"\n";
            i++;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Output/robust.csv")));
        writer.write(str);

        writer.close();
    }

    public void worstCase() throws IOException {
        int c = (int) Math.pow(5,p);
        int[][] Cases = new int[p][c];
        String str = "TestCaseID,";

        for (int x = 0; x < p; x++) {
            str = str + "parameter" + String.valueOf(x + 1) + ",";
        }
        str = str + "expectedValue" + "\n";
        nominalValue();
        for(int x=0;x<p;x++){
            worst[x][0] = nom[x];
            worst[x][1] = min[x];
            worst[x][2] = max[x];
            worst[x][3] = min[x]+1;
            worst[x][4] = max[x]-1;
        }

        for(int i=0; i < p; i++)
        {
            for (int j=0; j<c; j++)
            {
                Cases[i][j] = worst[i][(j/(int) Math.pow(5,i))%5];
                System.out.println(Cases[i][j]);
            }
        }

        for (int i=0; i<c; i++)
        {
            str =str +String.valueOf(i+1)+",";
            for (int j=0; j<p; j++)
            {
                str = str + Cases[j][i] + ",";
            }
            str = str + "\n";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Output/WorstCase.csv")));
        writer.write(str);

        writer.close();

    }

}


