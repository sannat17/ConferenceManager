package entities;


import java.time.LocalTime;

/** Initializes a message as a reply or first message depending on the constructor called */
public class Message {

    private String messageContent;
    private int senderID;
    private int receiverID;
    private LocalTime timeSent;
    private int messageID;
    private int replyToID;  //stores the ID of the message that this is a reply to (if it's a reply); -1 if not a reply

    public Message(int senderID,  int receiverID, int messageID, int replyToID, String messageContent){
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.messageContent = messageContent;
        this.replyToID = replyToID;
        this.timeSent = LocalTime.now();  //immutable object that represents a time without a date and a time-zone
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
