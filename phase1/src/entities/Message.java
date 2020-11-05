package entities;

import java.time.LocalTime;

public class Message {
    private String messageContent;
    private int senderID;
    private int receiverID;
    private LocalTime timeSent;

    public Message(int senderID,  int receiverID, String messageContent){
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.messageContent = messageContent;
        this.timeSent = LocalTime.now();  //immutable object that represents a time without a date and a time-zone
    }

    public int getSenderID(){
       return senderID;
    }

    public int getReceiverID(){
        return receiverID;
    }

    public String getMessageContent(){
        return messageContent;
    }

    public LocalTime getTimeSent(){
        return timeSent;
    }
}
