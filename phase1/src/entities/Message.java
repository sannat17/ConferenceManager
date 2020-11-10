package entities;

import controllers.MessageInput;

import java.time.LocalTime;

public class Message {
    private String messageContent;
    private int senderID;
    private int receiverID;
    private LocalTime timeSent;
    private int messageID;
    private int replyToID;  //stores the ID of the message that this is a reply to(if it's a reply)

    public Message(int senderID,  int receiverID, int messageID, String messageContent){
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.messageContent = messageContent;
        this.replyToID = -1;
        this.timeSent = LocalTime.now();  //immutable object that represents a time without a date and a time-zone
        // shouldn't we define time sent when the user chooses to send?//im assuming the message constructor will be called when the message is sent?
    }

    public Message(int senderID,  int receiverID, int messageID, int replyToID, String messageContent){
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.messageContent = messageContent;
        this.replyToID = replyToID;
        this.timeSent = LocalTime.now();  //immutable object that represents a time without a date and a time-zone
        // shouldn't we define time sent when the user chooses to send?//im assuming the message constructor will be called when the message is sent?
    }

    public int getSenderID(){
       return senderID;
    }

    public int getReceiverID(){
        return receiverID;
    }

    public int getMessageID(){return messageID;}

    public int getReplyToID() { return replyToID;}

    public String getMessageContent(){
        return messageContent;
    }

    public LocalTime getTimeSent(){
        return timeSent;
    }

}
