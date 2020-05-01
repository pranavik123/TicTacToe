package com.tictactoe;

import java.util.Scanner;

public class TicTactoeGame {
	public static void print(char a[][]){
		for(int i=0;i<3;i++){
			System.out.print("  "+i+"");
		}
		System.out.println();
		for(int i=0;i<3;i++){
			System.out.print(i);
			for(int j=0;j<3;j++){
				System.out.print("|"+a[i][j]+"|");
				
			}
			System.out.println("\n----------");
			
		}
	}
	public static boolean rowcheck(char a[][],char player){
		int flag=1;
		for(int i=0;i<3;i++){
			flag=1;
			for(int j=0;j<3;j++){
				if(a[i][j]!=player){
					flag=0;
					continue;
				}
				
			}
			if(flag==1){
				return true;
			}
		}
		return false;
	}
	public static boolean colcheck(char a[][],char player){
		int flag=1;
		for(int i=0;i<3;i++){
			flag=1;
			for(int j=0;j<3;j++){
				if(a[j][i]!=player){
					flag=0;
					continue;
				}
				
			}
			if(flag==1){
				return true;
			}
		}
		return false;
	}
	public static boolean diagonalcheck(char a[][],char player){
		if(a[0][0]==player && a[1][1]==player && a[2][2]==player){
			return true;
		}
		if(a[0][2]==player && a[1][1]==player && a[2][0]==player){
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		System.out.println("\t\t\t TIC TAC TOE");
		char a[][]=new char[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				a[i][j]=' ';
			}
		}
		print(a);
		char player='X';
		int flag=0;
		int count=0;
		for(int i=0;i<9;i++){
			System.out.println("It's your turn" +player);
			System.out.println("Please give according to the rows and columns index");
			System.out.println("Enter r and c");
			int r=in.nextInt();
			int c=in.nextInt();
			if(a[r][c]==' '){
				count+=1;
				a[r][c]=player;
			}
			else{
				System.out.println("It is filled");
			}
			print(a);
			
			if(count>=5){
				if(rowcheck(a,player)){ 
					System.out.println(player+ " Player Wins.....Congrats Row Win");
					flag=1;
					break;
				}
				if(colcheck(a,player)){
					System.out.println(player+ " Player Wins.....Congrats Column win");
					flag=1;
					break;
				}
				if(diagonalcheck(a,player)){
					System.out.println(player+ " Player Wins.....Congrats diagonal Win");
					flag=1;
					break;
				}
			}
			
			if(player=='X'){
				player='O';
			}else{
				player='X';
			}
		}
		if(count==9 &&(flag==0)){
			System.out.println("Game Over It's a Tie Nice Fight");
		}
	}
	

}
