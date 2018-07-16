package com.example.intern.newsreader.model;

import com.example.intern.newsreader.model.AnnouncementDate;
import com.example.intern.newsreader.model.AnnouncementDescription;
import com.example.intern.newsreader.model.AnnouncementHTML;
import com.example.intern.newsreader.model.AnnouncementImage;
import com.example.intern.newsreader.model.AnnouncementImageThumbnail;
import com.example.intern.newsreader.model.AnnouncementTitle;
import com.example.intern.newsreader.model.Expiry;
import com.example.intern.newsreader.model.Id;
import com.example.intern.newsreader.model.NativeDate;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsItem {

    @SerializedName("ID")
    @Expose
    private Id id;
    @SerializedName("NATIVE_DATE")
    @Expose
    private NativeDate nativeDate;
    @SerializedName("ANNOUNCEMENT_DATE")
    @Expose
    private AnnouncementDate announcementDate;
    @SerializedName("EXPIRY")
    @Expose
    private Expiry expiry;
    @SerializedName("ANNOUNCEMENT_DESCRIPTION")
    @Expose
    private AnnouncementDescription announcementDescription;
    @SerializedName("ANNOUNCEMENT_TITLE")
    @Expose
    private AnnouncementTitle announcementTitle;
    @SerializedName("ANNOUNCEMENT_IMAGE")
    @Expose
    private AnnouncementImage announcementImage;
    @SerializedName("ANNOUNCEMENT_IMAGE_THUMBNAIL")
    @Expose
    private AnnouncementImageThumbnail announcementImageThumbnail;
    @SerializedName("ANNOUNCEMENT_HTML")
    @Expose
    private AnnouncementHTML announcementHTML;

    public Id getID() {
        return id;
    }

    public void setID(Id id) {
        this.id = id;
    }

    public NativeDate getNativeDate() {
        return nativeDate;
    }

    public void setNativeDate(NativeDate nativeDate) {
        this.nativeDate =  nativeDate;
    }

    public AnnouncementDate getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(AnnouncementDate announcementDate) {
        this.announcementDate = announcementDate;
    }

    public Expiry getExpiry() {
        return expiry;
    }

    public void setExpiry(Expiry expiry) {
        this.expiry = expiry;
    }

    public AnnouncementDescription getAnnouncementDescription() {
        return announcementDescription;
    }

    public void setAnnouncementDescription(AnnouncementDescription announcementDescription) {
        this.announcementDescription= announcementDescription;
    }

    public AnnouncementTitle getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(AnnouncementTitle announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public AnnouncementImage getAnnouncementImage() {
        return announcementImage;
    }


    public void setAnnouncementImage(AnnouncementImage announcementImage) {
        this.announcementImage = announcementImage;
    }


    public AnnouncementImageThumbnail getAnnouncementImageThumbnail() {
        return announcementImageThumbnail;
    }


    public void setAnnouncementImageThumbnail(AnnouncementImageThumbnail announcementImageThumbnail) {
        this.announcementImageThumbnail = announcementImageThumbnail;
    }


    public AnnouncementHTML getAnnouncementHTML() {
        return announcementHTML;
    }


    public void setAnnouncementHTML(AnnouncementHTML announcementHTML) {
        this.announcementHTML = announcementHTML;
    }
}
