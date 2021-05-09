package HomeWork09052021;

import java.util.Arrays;
import java.util.Scanner;

public class CreatArrayWithSize100 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size array");
        int size=sc.nextInt();
        int choice;
        int []arr=new int[size];
        for (int i=0;i<arr.length;i++){
            System.out.println("element "+" "+i);
            arr[i]=sc.nextInt();
        }
        do{
            System.out.println("========MENU========");
            System.out.println("1. Hiển thị mảng vừa nhập");
            System.out.println("2. Tìm số chẵn lớn nhất trong mảng");
            System.out.println("3. Liệt kê danh sách các số chẵn trong mảng");
            System.out.println("4. Tính tổng các số chẵn trong mảng");
            System.out.println("5. Nhập vào giá trị và vị trí cần chèn của giá trị đó trong mảng, chèn giá trị đó vào mảng");
            System.out.println("6. Xoá tất cả các phần tử có giá trị bằng X (được nhập từ bàn phím) khỏi mảng");
            System.out.println("7. Đảo ngược mảng ban đầu");
            System.out.println("8. Sắp xếp mảng theo thứ tự giảm dần");
            System.out.println("9. Thoát");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println(Arrays.toString(arr));
                    break;
                case 2:
                    System.out.println(findEvenMax(arr));
                    break;
                case 3:
                    listEvenNumber(arr);
                    break;
                case 4:
                    System.out.println(sumEvenNumber(arr));
                    break;
                case 5:
                    System.out.println("Enter value to add to array");
                    int newValue= sc.nextInt();
                    System.out.println("Enter index to add to new array ");
                     int newIndex= sc.nextInt();
                   insertNumber(newIndex,newValue,arr);
                    break;
                case 6:
                    deleteSameNumber(arr);
                    break;
                case 7:
                    reverseArr(arr);
                    break;
                case 8:
                    descendingArrangement(arr);
                    break;
                case 9:
                    System.exit(0);

                    break;
            }

        }while (choice>=1 && choice<=11);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(findEvenMax(arr));
        // listEvenNumber(arr);
        //System.out.println(sumEvenNumber(arr));

//        System.out.println("Enter value to add to array");
//        int newValue= sc.nextInt();
//        System.out.println("Enter index to add to new array ");
//        int newIndex= sc.nextInt();
//        insertNumber(newIndex,newValue,arr);
//       deleteSameNumber(arr);
 //       reverseArr(arr);
        //     descendingArrangement(arr);



    }
    public static int findEvenMax(int[]arr){
        int evenMax=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>evenMax && arr[i]% 2==0){
                arr[i]=evenMax;
            }
        }
        return evenMax;
    }
    public static void  listEvenNumber(int[]arr){

        for(int i=0;i< arr.length;i++){
            if(arr[i]%2==0){
                System.out.println(arr[i]);
            }
        }
        System.out.println();

    }
    public static int sumEvenNumber(int []arr){
        int sum=0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]%2==0){
                sum+=arr[i];
            }
        }
        return sum;
    }
    public static  void insertNumber( int newIndex,int newValue,int[]arr){
    if(newIndex<0 || newIndex> arr.length){
        System.out.println("Invalid Index");
    }else {
        int []newArr=new int[arr.length+1];
        for(int i=0;i<newArr.length;i++){
            if(i<newIndex){
                newArr[i]=arr[i];
            }else if( i==newIndex){
                newArr[i]=newValue;
            }else {
                newArr[i]=arr[i-1];
            }
        }
        System.out.println(Arrays.toString(newArr));
    }

    }
public static void deleteSameNumber(int[]arr){
        boolean find;
        int count =0;
        int []newArr=new int[arr.length];
        newArr[0]=arr[0];
        count ++;
        for(int i=0;i<arr.length;i++){
            find=false;
            for(int j=0;i<count;j++){
                if(newArr[j]==arr[i]){
                    find=true;
                    break;
                }
            }
            if(!find){
                newArr[count]=arr[i];
                count++;
            }
        }
        arr=new int[count];
        for(int i=0;i<arr.length;i++){
            arr[i]=newArr[i];
        }
    System.out.println("New Array after delete same number");
        for(int i:arr){
            System.out.println(i);
        }
}
public static void reverseArr(int []arr){
        for(int i =0;i<arr.length/2;i++){
            int temp= arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
    System.out.println("reverse array");
        for(int j=0;j<arr.length;j++){
            System.out.println(arr[j]+"\t");
        }
}



public static void descendingArrangement(int[]arr){
int temp;
    for (int i = 0; i < ( arr.length ); i++) {
        for (int j = 0; j < arr.length-i -1; j++) {
            if (arr[j] < arr[j+1])
            {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    System.out.println("Kết quả sau khi sắp xếp theo thứ tự giảm dần là: ");
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + "\t");
    }


}



}
