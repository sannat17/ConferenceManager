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
    /** The ID of the message that this message is either unread (0), read (1), archived (-2)*/
    private int statusID;
    /**
    private
     * Create a new Message
     *
     * @param senderID the ID of the sender of this message
     * @param receiverID the ID of the receiver of this message
     * @param messageID the unique ID of this message
     * @param replyToID the unique ID of the message that this message is a reply to(if it's a reply); -1 if not a reply
     * @param messageContent the content of this message
     */
    public Message(int senderID, int receiverID, int messageID, int replyToID, String messageContent){
        this.messageID = messageID;
        this.senderID = senderID;
        this.statusID = 0;
        this.receiverID = receiverID;
        this.messageContent = messageContent;
        this.replyToID = replyToID;
        this.timeSent = LocalTime.now();  //immutable object that represents a time without a date and a time-zone
    }


    /** Converts a message and its details to a string. */
    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return  senderID + delimiter + statusID + delimiter + receiverID + delimiter + messageID + delimiter + replyToID
                + delimiter + messageContent;
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

    /**
     *
     * @return The statusID of this message
     */
    public int getStatusID() { return statusID; }

    /** Sets the statusID of the message according to the parameter
     * @param ID ID that the program wants to set as the status of the message.
     */
    public void setStatusID(int ID) { this.statusID = ID; }
}
