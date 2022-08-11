import java.util.Scanner;

public class wordSearch {
    static boolean search(char mat[][], String word, int i, int j,
    int nrow, int ncol, int stillMatched){
       
        //if matched
        if(stillMatched >=word.length()){
            return true;
        }

        if (i < 0 || j < 0 || i >= nrow || j >= ncol)
            return false;//not matched
        
        if(mat[i][j] == word.charAt(stillMatched)){
            //calling in every direction
            char t = mat[i][j];
            mat[i][j]= '*';
            boolean res = search(mat,word,i+1,j,nrow,ncol,stillMatched+1)/*right*/ || search(mat,word,i-1,j,nrow,ncol,stillMatched+1)/*left*/||search(mat,word,i,j+1,nrow,ncol,stillMatched+1)/*down*/||search(mat,word,i,j-1,nrow,ncol,stillMatched+1);//up
            mat[i][j] = t;
            return res;
        }else
            return false;
    }

    static boolean matchBy(char mat[][], String word, int nrow, int ncol){
        if(word.length() > (nrow*ncol)){//if word bigger
            return false;
        }
        for(int i=0;i<nrow;i++){//from where match start
            for(int j=0;j<ncol;j++){
                if(mat[i][j]== word.charAt(i)){//start searching when first match found
                    if (search(mat, word, i, j, nrow, ncol, 0))
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter row: ");
        int r = sc.nextInt();
        System.out.print("\nEnter column: ");
        int c = sc.nextInt();
        char[][] mat = new char[r][c];
        System.out.print("Enter the characters: ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j] = sc.next().charAt(0);
            }
        }

        
        int n = sc.nextInt();
        System.out.println("\nEnter word you want to search:");
        String word = sc.next();
        System.out.println(matchBy(mat, word,r,c));
        sc.close();
    }
}

