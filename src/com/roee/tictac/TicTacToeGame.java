package com.roee.tictac;


public class TicTacToeGame {
private char mBoard[];
static final char LOCAL_PLAYER='x';
static final char REMOTE_PLAYER='o';
static final char EMPTY_SLOT=' ';

public int getBoardSize()
{
	return 9;
}
public TicTacToeGame() {
mBoard=new char[9];
for (int i = 0; i < mBoard.length; i++) {
	mBoard[i]=EMPTY_SLOT;
}
}
public void clearBoard()
{
	for (int i = 0; i < mBoard.length; i++) {
		mBoard[i]=EMPTY_SLOT;
}
}
/**
 * 
 * @param player remote or local
 * @param location where it taken
 * @return true on success
 */
public boolean setMove(char player, int location){
	//checking input is valid
if((player==LOCAL_PLAYER||player==REMOTE_PLAYER)&&(location<9&&location>=0))
	//checks if the slot is empty
	if(mBoard[location]==EMPTY_SLOT)
	{
		mBoard[location]=player;
		return true;
	}
return false;
}
public boolean isSlotEmpty(int location)
{
	return location<9&&location>0 ? mBoard[location]==EMPTY_SLOT : false;
}
/**
 * @return 1- you win
 * 0 - nobody win
 * -1 - remote win
 * 2 - tie
 */
public int CheckWin()
{
	//check line
for(int i=0;i<9;i=+3)
{
	if((mBoard[i]==REMOTE_PLAYER||mBoard[i]==LOCAL_PLAYER)&&mBoard[i]==mBoard[i+1]&&mBoard[i]==mBoard[i+2])
		return mBoard[i]==REMOTE_PLAYER ? -1 : 1;
}
// check row
for(int i=0;i<9;i++)
{
	if((mBoard[i]==REMOTE_PLAYER||mBoard[i]==LOCAL_PLAYER)&&mBoard[i]==mBoard[i+3]&&mBoard[i]==mBoard[i+6])
		return mBoard[i]==REMOTE_PLAYER ? -1 : 1;
}
// check diagonal 
if((mBoard[0]==REMOTE_PLAYER||mBoard[0]==LOCAL_PLAYER)&&mBoard[0]==mBoard[4]&&mBoard[0]==mBoard[8])
	return mBoard[0]==REMOTE_PLAYER ? -1 : 1;
if((mBoard[2]==REMOTE_PLAYER||mBoard[2]==LOCAL_PLAYER)&&mBoard[2]==mBoard[4]&&mBoard[2]==mBoard[6])
	return mBoard[2]==REMOTE_PLAYER ? -1 : 1;
// check tie
for(int i=0;i<9;i++)
{
	if(mBoard[i]==EMPTY_SLOT)
		return 0;
}
return 2;
}
}
