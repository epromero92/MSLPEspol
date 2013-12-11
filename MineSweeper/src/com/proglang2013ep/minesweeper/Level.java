package com.proglang2013ep.minesweeper;


public class Level {
		private String level;
		private int id;
		public Level(String string, int id){
			this.level = string;
			this.id= id;
		}
		public String getLevel(){
			return level; 
		}
		public int getId(){
			return id;
		}
		
}
