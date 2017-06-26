package com.roadtex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="PICTURE")
public class Picture {
	
	@Id
    @GeneratedValue
    @Column(name="PIC_ID")
	private int picID;
	
	@Column(name="PIC_NAME", nullable=false)
	private String caption;
	
	@Lob
    @Column(name="PIC_IMAGE", nullable=false, columnDefinition="mediumblob")
	private byte[] image;
	public Picture() {
	super();
	// TODO Auto-generated constructor stub
	}

public int getPicID() {
	return picID;
}
public void setPicID(int picID) {
	this.picID = picID;
}
public String getCaption() {
	return caption;
}
public void setCaption(String caption) {
	this.caption = caption;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}

}
