/**
* Board.java
*
* @version   $Id: Board.java,v_1.0 2014/09/09 18:22:00
*
* @author    hhk9433 (Hrishikesh Karale)
* @author    ap8185 (Atir Petkar)
*
* Revisions:
*      Initial revision
*/


/*
 * This program places maximum number of queens on the given board
 * without them attacking each other.
 */

public class Board {
	
	static char [][] duplicateChessBoard;	//stores the possible positions of queens for every iteration
	static Board boardObject;	//board object
	static int duplicateQueenCount;	//counts no of queens on duplicateChessBoard

	private void display(char [][] boardDisplay)
	{
		
		for(int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
				System.out.print(boardDisplay[i][j]);
			System.out.println();
		}
		
	}
	
	
	private boolean isWall(int row1, int row2, int column1, int column2)
	{
		/*
		 * This method returns true if there exists a wall between two blocks
		 *  and vice versa
		 */
		
		switch(row1)
		{
			case 0: switch(column1)
					{
						case 5:if((row2==0 || row2==1) && column2==6 )
									return true;
								break;
						case 6:if((row2==0 || row2==1) && column2==5 )
									return true;
								break;
						default:return false;
					}
					break;
			
			case 1: switch(column1)
					{
						case 0:if(row2==2 && (column2==1 || column2==0) )
									return true;
						 		break;
						case 1:if(row2==2 && (column2==1 || column2==0 || column2==2) )
									return true;
								break;
						case 2:if(row2==2 && (column2==1 || column2==2) )
									return true;
								break;
						case 3:if((row2==1 || row2==2 ) && column2==4 )
									return true;
								break;
						case 4:if((row2==1 || row2==2 ) && column2==3 )
									return true;
								break;
						default:return false;
					}
					break;
			
			case 2: switch(column1)
					{
						case 0:if(row2==1 && (column2==1 || column2==0) )
									return true;
						 	break;
						case 1:if(row2==1 && (column2==1 || column2==0 || column2==2) )
									return true;
								break;
						case 2:if(row2==1 && (column2==1 || column2==2) )
									return true;
								break;
						case 3:if(((row2==1 || row2==2 || row2==3) && column2==4) || (row2==3 && column2==3))
									return true;
								break;
						case 4:if(((row2==1 || row2==2 || row2==3) && column2==3) || (row2==3 && (column2==4 || column2==5)))
									return true;
								break;
						case 5:if(row2==3 && (column2==4 || column2==5))
									return true;
								break;
						default:return false;
					}
					break;
			
			case 3: switch(column1)
					{
						case 3:if(row2==2 && (column2==3 || column2==4))
									return true;
								break;
						case 4:if((row2==2 && (column2==3|| column2==4 || column2==5)) || (row2==3 && column2==5))
									return true;
								break;
						case 5:if(((row2==2 && (column2==4 || column2==5)) ||(row2==3 && column2==4)))
									return true;
								break;
						default: return false;
					}
					break;
			
			case 4: switch(column1)
					{
						case 1:if((row2==4 || row2==5) && column2==2)
									return true;
								break;
						case 2:if((row2==4 || row2==5) && column2==1)
									return true;
								break;
						case 4:if(( row2==4 || row2==3) && column2==5)
									return true;
								break;
						case 5:if((column2==4 && (row2==3 || row2==4 || row2==5)) || (row2==5 && (column2==5 || column2==6)))
									return true;
								break;
						case 6:if(row2==5 && (column2==5 || column2==6 || column2==7))
									return true;
								break;
						case 7:if(row2==5 && (column2==6 || column2==7))
									return true;
								break;
						default: return false;
					}
					break;
			
			case 5: switch(column1)
					{
						case 1:if((row2==4 || row2==5) && column2==2)
									return true;
								break;
						case 2:if(((row2==4 || row2==5 || row2==6) && column2==1) && ( row2==6 && (column2==2 || column2==3)))
									return true;
								break;
						case 3:if(row2==6 && (column2==3 || column2==2 || column2==4))
									return true;
								break;
						case 4:if((row2==6 && (column2==3 || column2==4)) || (row2==4 && column2==5))
									return true;
								break;
						case 5:if(row2==4 && (column2==5 || column2==6 ))
									return true;
								break;
						case 6:if(row2==4 && (column2==5 || column2==6 || column2==7))
									return true;
								break;
						case 7:if(row2==4 && (column2==6 || column2==7))
									return true;
								break;
						default:return false;
					}
					break;
			
			case 6: switch(column1)
					{
						case 0:if(row2==7 && column2==0)
									return true;
								break;
						case 1:if((row2==5 && column2==2) || (row2==7 && column2==0))
									return true;
								break;
						case 2:if(row2==5 && (column2==3 || column2==2))
									return true;
								break;
						case 3:if(row2==5 && (column2==3 || column2==2 || column2==4))
									return true;
								break;
						case 4:if(row2==5 && (column2==3 || column2==4))
									return true;
								break;
						case 5:if(row2==6 && (column2==6 || column2==7))
									return true;
								break;
						case 6:if((row2==7 || row2==6) && column2==5)
									return true;
								break;
						default:return false;
					}
					break;
			
			case 7: switch(column1)
					{
						case 0:if((row2==7 && column2==1) || (row2==6 && (column2==0 || column2==1)))
									return true;
								break;
						case 1:if(row2==7 && column2==0)
									return true;
								break;
						case 5:if((row2==7 || row2==6) && column2==6)
									return true;
								break;
						case 6:if((row2==7 || row2==6) && column2==5)
									return true;
								break;
						default:return true;
					}
			default:return false;
		}
		return false;
	}
	public void block(int row, int column)
	{
		/*
		 * This method blocks the attacking position of the queen diagonally, vertically and horizontally,
		 *  also checks for walls present.
		 */
		
		int row2=row+1;
		while(row2<8)	//blocks vertically upward
		{
			if(duplicateChessBoard[row2][column]!=' ' && boardObject.isWall(row2-1, row2, column, column)==false)
				duplicateChessBoard[row2++][column]='-';
		}
		
		row2=row-1;
		while(row2>=0)	//blocks vertically downwards
		{
			if(duplicateChessBoard[row2][column]!=' ' && boardObject.isWall(row2+1, row2, column, column)==false)
				duplicateChessBoard[row2--][column]='-';
		}
		
		int column2=column+1;
		while(column2<8)	// blocks horizontally to the right
		{
			if(duplicateChessBoard[row][column]!=' ' && boardObject.isWall(row, row, column2-1, column2)==false)
				duplicateChessBoard[row][column++]='-';
		}
		
		column2=column-1;
		while(column2>=0)	// blocks horizontally to the left
		{
			if(duplicateChessBoard[row][column2]!=' ' && boardObject.isWall(row2, row2, column2+1, column2)==false)
				duplicateChessBoard[row][column2--]='-';
		}
		
		
		row2=row-1;
		column2=column+1;
		while(row2>=0 && column2<8)	//blocks diagonally upwards right
		{
			if(duplicateChessBoard[row2][column]!=' ' && boardObject.isWall(row2+1, row2, column2-1, column2)==false)
				duplicateChessBoard[row2--][column++]='-';
		}
		
		row2=row+1;
		column2=column-1;
		while(row2>8 && column2>=0)	//blocks diagonally downwards left
		{
			if(duplicateChessBoard[row2][column]!=' ' && boardObject.isWall(row2-1, row2, column+1, column)==false)
				duplicateChessBoard[row2++][column--]='-';
		}
		
		row2=row-1;
		column2=column-1;
		while(row2>=0 && column2>=0)	// blocks diagonally upwards left
		{
			if(duplicateChessBoard[row][column]!=' ' && boardObject.isWall(row+1, row, column2+1, column2)==false)
				duplicateChessBoard[row++][column++]='-';
		}
		
		row2=row+1;
		column2=column+1;
		while(row2<8 && column2<8)	//blocks diagonally downwards right
		{
			if(duplicateChessBoard[row][column2]!=' ' && boardObject.isWall(row2-1, row2, column2-1, column2)==false)
				duplicateChessBoard[row--][column2--]='-';
		}
				
	}

		
	private void placeQueen(int row, int column)
	{
		/*
		 * checks if the the block is suitable to place a queen while keeping track of bounds of array
		 * if a queen can be placed in the given position then it places the queen in that position
		 * and calls block() so as to block the vertical horizontal and diagonal attacking positions
		 * of the queen
		 */
		
		while(row<8)	//checks if no of rows are in bounds
		{
			if(duplicateChessBoard[row][column]==' ')	// checks availability of vacancy for queen
				{
					duplicateChessBoard[row][column]='Q';
					duplicateQueenCount++;
					boardObject.block(row, column);
					if(++column==8)	// checks no of columns don't exceed their bounds
					{
						row++;
						column=0;
						placeQueen(row,column);	//recursive method call
					}
				}
			else if(++column==8)	//checks no of columns don't exceed their bounds
			{
				row++;
				column=0;
				placeQueen(row, column);	//recursive method call
			}
		}		
	}
	

	public static void main(String[] args)
	{
		
		int queenCount=0;	//counts no of queens placed on chessBoard
		char [][] chessBoard;	//stores best case scenario
		chessBoard = new char [8][8];	//chessBoard Initialized
		duplicateChessBoard = new char [8][8];	//duplicateChessBoard Initialized
		boardObject = new Board();	//board object initialized
		
		for(int row=0; row<8; row++)	//Initializes chessBoard and duplicateChessBoard to defaults
			for (int column=0; column<8; column++)
			{
				chessBoard[row][column]=' ';
				duplicateChessBoard[row][column]=' ';
			}
		
		for ( int row=0; row<8; row++ )
			for(int column=0; column<8; column++)
				{
				
				/*
				 * calls placeQueen() for every possible position of queen on board
				 * compares the dublicateChessBoard and chessBoard and stores the best 
				 * board positions on chessBoard 
				 */
					boardObject.placeQueen(row,column);
					
					queenCount=0;
					
					for(int row1=0; row1<8; row1++)	// counts no of Queens on chessBoard
						for(int column1=0;column1<8; column1++)
							if(chessBoard[row1][column1]=='Q')
								queenCount++;
					
					if(duplicateQueenCount>queenCount)	// compares queen count from both chess boards
					{
						for(int row2=0; row2<8; row2++)	
							for(int column2=0;column2<8; column2++)
								chessBoard[row2][column2]=duplicateChessBoard[row2][column2];
						queenCount=duplicateQueenCount;
					}
				}
		boardObject.display(chessBoard);
		System.out.print("\nTotal Number of Queens: "+queenCount);
	}

}