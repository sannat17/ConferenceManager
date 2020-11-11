package entities;


import java.time.LocalTime;

/** Initializes a message as a reply or first message depending on the constructor called */
public class Message {
    /** The content of the message */
    private String messageContent;
    /** The ID of the message sender */
    private int senderID;
    /** The ID of the message receiver */
    private int receiverID;
    /** The time this message was sent */
    private LocalTime timeSent;
    /** The ID of this message*/
    private int messageID;
    /** The ID of the message that this message is a reply to(if it's a reply); -1 if not a reply*/
    private int replyToID;
    /**
     * Create a new Message
     *
     * @param senderID the ID of the sender of this message
     * @param receiverID the ID of the receiver of this message
     * @param messageID the unique ID of this message
     * @param replyToID the unique ID of the message that this message is a reply to(if it's a reply); -1 if not a reply
     * @param messageContent the content of this message
     */
    public Message(int senderID,  int receiverID, int messageID, int replyToID, String messageContent){
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.messageContent = messageContent;
        this.replyToID = replyToID;
        this.timeSent = LocalTime.now();  //immutable object that represents a time without a date and a time-zone
    }

    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return  senderID + delimiter + receiverID + delimiter + messageID + delimiter + replyToID + delimiter
                + messageContent + delimiter + timeSent;
    }

    /** Converts a message and its details to a string to be used by the presenter */
    public String toStringP() {
        String delimiter = Character.toString((char) 31);
        return  senderID + delimiter + receiverID + delimiter + timeSent + delimiter + messageContent;
    }
    /**
     *
     * @return The ID of the sender of this message
     */
    public int getSenderID(){
       return senderID;
    }
    /**
     *
     * @return The ID of the reciever of this message
     */
    public int getReceiverID(){
        return receiverID;
    }
    /**
     *
     * @return The ID of the messageID of this message
     */
    public int getMessageID(){return messageID;}
    /**
     *
     * @return The ID of the reply of this message
     */
    public int getReplyToID() { return replyToID;}
    /**
     *
     * @return The content of this message
     */
    public String getMessageContent(){
        return messageContent;
    }
    /**
     *
     * @return The time this message was sent
     */
    public LocalTime getTimeSent(){
        return timeSent;
    }

}
