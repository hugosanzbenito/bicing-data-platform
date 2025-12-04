public class Message {
	
	private String text;
	private long chat_id;
	
	
	public Message(long chat_id, String text) {
		this.text = text;
		this.chat_id = chat_id;
	}
	
	public Message(String text) {
		this.text = text;
	}

	public Message() {
	}

    

    // toString method
    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                '}';
    }



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getChat_id() {
		return chat_id;
	}

	public void setChat_id(long chat_id) {
		this.chat_id = chat_id;
	}
	
}