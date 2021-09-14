import java.util.Scanner;

public class SubMatrix{

  private int matrix [][];

  private int sum [][];

  public SubMatrix (){
    Scanner sc = new Scanner (System.in);
    System.out.print("Enter de Rows Size ");
    int rows = Integer.parseInt(sc.nextLine());
    System.out.print("Enter de Colums Size ");
    int colums = Integer.parseInt(sc.nextLine());
    matrix = new int[rows][colums];
    sum = new int[rows][colums];
    sum = matrix;
    for (int i = 0;i<rows;i++){
        String temp = sc.nextLine();
        String []tempRow = temp.split(" ");
        for (int j =0;j<colums;j++){
          matrix [i][j] = Integer.parseInt(tempRow[j]);
        }
    }

    calculateSum();
    printMatrix();
    coordinates();


  }
  public static void main (String args[]){
    SubMatrix csm = new SubMatrix();
  }

  public void calculateSum (){
    sum [0][0] = matrix[0][0];

    for (int i = 1;i<matrix.length;i++){
      sum[i][0]=matrix[i][0]+sum[i-1][0];
    }
    for (int i = 1;i<matrix[0].length;i++){
      sum[0][i]=matrix[0][i]+sum[0][i-1];
    }

    for (int i = 1;i<matrix.length;i++){
      for (int j = 1;j<matrix[0].length;j++){
        sum[i][j]= matrix[i][j]-sum[i-1][j-1]+sum[i-1][j]+sum[i][j-1];
      }
    }
  }
  public void printMatrix(){

    for (int i =0;i<matrix.length;i++){
      for (int j =0;j<matrix[0].length;j++){
        System.out.print(matrix[i][j]+String.valueOf('\t'));
      }
      System.out.println();
    }
    System.out.println();
    for (int i =0;i<matrix.length;i++){
      for (int j =0;j<matrix[0].length;j++){
        System.out.print(sum[i][j]+String.valueOf('\t'));
      }
      System.out.println();
    }
    System.out.println();

  }
  public void coordinates(){

    Scanner sc = new Scanner (System.in);
    int i1,j1,i2,j2;
    String cord1[],cord2[];
    int sumReturn;

    System.out.println("Continously, enter the range coordinates as pairs separating them with a ',' Ex: 0,1 ; 2,3 ; ...");

    System.out.println("enter the first Coordinate ");
    String coord1 = sc.next();
    System.out.println("enter the second Coordinate ");
    String coord2 = sc.next();

    cord1 = coord1.split(",");
    cord2 = coord2.split(",");

    i1 = Integer.parseInt(cord1[0]);
    j1 = Integer.parseInt(cord1[1]);
    i2 = Integer.parseInt(cord2[0]);
    j2 = Integer.parseInt(cord2[1]);

    if (i1==0&&j1==0){

        sumReturn = matrix[i2][j2];
        System.out.println(sumReturn);
        return;
    }
    if (i2<i1||j2<j1){
      System.err.println("Error");
    }else {
      if (i1==0){
        sumReturn=sum[i2][j2]-sum[i2][j1-1];
        System.out.println(sumReturn);
        return;
      }else {
        if (j1==0){
        sumReturn=sum[i2][j2]-sum[i1-1][j2];
        System.out.println(sumReturn);
        return;
        }
      }
    }

    if (i1!=0&&j2!=0) {
      sumReturn = sum[i2][j2] - sum[i2][j1 - 1] - sum[i1 - 1][j2] + sum[i1 - 1][j1 - 1];
      System.out.println(sumReturn);
    }

  }

}
