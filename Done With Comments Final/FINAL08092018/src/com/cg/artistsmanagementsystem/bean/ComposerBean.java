package com.cg.artistsmanagementsystem.bean;

import java.sql.Date;
import java.time.LocalDate;

public class ComposerBean {
	private int composerId; 
	private String composerName;
	private String composerBornDate;
	private String composerDiedDate;
	private String composerCaeipiNumber;
	private String composerMusicSocietyID;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	private String composerMusicSociety;
	private char composerDeletedFlag;
	public int getComposerId() {
		return composerId;
	}
	public void setComposerId(int composerId) {
		this.composerId = composerId;
	}
	public String getComposerName() {
		return composerName;
	}
	public void setComposerName(String composerName) {
		this.composerName = composerName;
	}
	public String getComposerBornDate() {
		return composerBornDate;
	}
	public void setComposerBornDate(String composerBornDate) {
		this.composerBornDate = composerBornDate;
	}
	public String getComposerDiedDate() {
		return composerDiedDate;
	}
	public void setComposerDiedDate(String composerDiedDate) {
		this.composerDiedDate = composerDiedDate;
	}
	public String getComposerCaeipiNumber() {
		return composerCaeipiNumber;
	}
	public void setComposerCaeipiNumber(String composerCaeipiNumber) {
		this.composerCaeipiNumber = composerCaeipiNumber;
	}
	public String getComposerMusicSocietyID() {
		return composerMusicSocietyID;
	}
	public void setComposerMusicSocietyID(String composerMusicSocietyID) {
		this.composerMusicSocietyID = composerMusicSocietyID;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public char getComposerDeletedFlag() {
		return composerDeletedFlag;
	}
	public void setComposerDeletedFlag(char composerDeletedFlag) {
		this.composerDeletedFlag = composerDeletedFlag;
	}
	
	public String getComposerMusicSociety() {
		return composerMusicSociety;
	}
	public void setComposerMusicSociety(String composerMusicSociety) {
		this.composerMusicSociety = composerMusicSociety;
	}
	public ComposerBean(int composerId, String composerName,
			String composerBornDate, String composerDiedDate,
			String composerCaeipiNumber, String composerMusicSocietyID,
			int createdBy, String createdOn, int updatedBy,
			String updatedOn, String composerMusicSociety,
			char composerDeletedFlag) {
		super();
		this.composerId = composerId;
		this.composerName = composerName;
		this.composerBornDate = composerBornDate;
		this.composerDiedDate = composerDiedDate;
		this.composerCaeipiNumber = composerCaeipiNumber;
		this.composerMusicSocietyID = composerMusicSocietyID;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.composerMusicSociety = composerMusicSociety;
		this.composerDeletedFlag = composerDeletedFlag;
	}
	public ComposerBean() {
		super();
		
	}
	@Override
	public String toString() {
		return "------------------------COMPOSER DETAILS------------------------\n ComposerId: " + composerId + "\n ComposerName: "
				+ composerName + "\n Composer Born Date: " + composerBornDate.substring(0, 10)
				+ "\n Composer Died Date: " + composerDiedDate.substring(0, 10)
				+ "\n Composer Caeipi Number: " + composerCaeipiNumber
				+ "\n Composer MusicSociety ID: " + composerMusicSocietyID
				+ "\n Created By: " + createdBy + "\n CreatedOn: " + createdOn
				+ "\n Updated By: " + updatedBy + "\n UpdatedOn: " + updatedOn
				+ "\n Composer Music Society: " + composerMusicSociety;
	}
	
	
	
}
