public class ChessboardCover {

    static int[][] board;
    static int tile=1;        //L型骨牌序号，根据填入的顺序给L型骨牌编号
    /*
     * tr：棋盘左上角方格的行号；tc：棋盘左上角方格的列号
     * dr：特殊方格的行号；dc：特殊方格的列号
     * size：棋盘的大小是size×size
     */
    static void ChessBoard(int tr,int tc,int dr,int dc,int size){
        if(size==1)
            return;
        int t=tile++;
        int s=size/2;         //分割棋盘
        //覆盖左上角棋盘
        if(dr<tr+s && dc<tc+s)
            ChessBoard(tr,tc,dr,dc,s);     //特殊方格在此棋盘中
        else{        //此棋盘无特殊方格
            board[tr+s-1][tc+s-1]=t;       //用t号L型骨牌覆盖此子棋盘的右下角
            ChessBoard(tr,tc,tr+s-1,tc+s-1,s);
        }
        //覆盖右上角棋盘
        if(dr<tr+s && dc>=tc+s)
            ChessBoard(tr,tc+s,dr,dc,s);
        else{
            board[tr+s-1][tc+s]=t;        //用t号L型骨牌覆盖此子棋盘的左下角
            ChessBoard(tr,tc+s,tr+s-1,tc+s,s);
        }
        //覆盖左下角棋盘
        if(dr>=tr+s && dc<tc+s)
            ChessBoard(tr+s,tc,dr,dc,s);
        else{
            board[tr+s][tc+s-1]=t;       //用t号L型骨牌覆盖此棋盘的右上角
            ChessBoard(tr+s,tc,tr+s,tc+s-1,s);
        }
        //覆盖右下角棋盘
        if(dr>=tr+s && dc>=tc+s)
            ChessBoard(tr+s,tc+s,dr,dc,s);
        else{
            board[tr+s][tc+s]=t;         //用t号L型骨牌覆盖此棋盘左上角
            ChessBoard(tr+s,tc+s,tr+s,tc+s,s);
        }
    }

    public static void main(String[] args) {
        int k=4;      //棋盘大小是2^k×2^k
        int size=(int)Math.pow(2, k);
        board=new int[size][size];
        ChessBoard(0,0,0,1,size);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.printf("%6d",board[i][j]);
            }
            System.out.println();
            System.out.println();
        }
    }

}
