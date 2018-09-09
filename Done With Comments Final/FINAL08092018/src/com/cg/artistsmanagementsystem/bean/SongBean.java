package com.cg.artistsmanagementsystem.bean;

public class SongBean {
	private int songId;
	private String songName;
	private String songDuration;
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongDuration() {
		return songDuration;
	}
	public void setSongDuration(String songDuration) {
		this.songDuration = songDuration;
	}
	public SongBean(int songId, String songName, String songDuration) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.songDuration = songDuration;
	}
	public SongBean() {
	
	}
	@Override
	public String toString() {
		return " --------------------------SONGS DETAILS--------------------------\n Song Id: " + songId + "\n Song Name: " 
				+ songName+ "\n Song Duration: " + songDuration.substring(8,15)+"\n------------------------------------------------------------------";
	}
	
}
