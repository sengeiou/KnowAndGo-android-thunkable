package org.apache.logging.log4j.message;

public class SimpleMessage implements Message {
    private static final long serialVersionUID = -8398002534962715992L;
    private final String message;

    public Object[] getParameters() {
        return null;
    }

    public Throwable getThrowable() {
        return null;
    }

    public SimpleMessage() {
        this((String) null);
    }

    public SimpleMessage(String str) {
        this.message = str;
    }

    public String getFormattedMessage() {
        return this.message;
    }

    public String getFormat() {
        return this.message;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SimpleMessage simpleMessage = (SimpleMessage) obj;
        if (this.message != null) {
            if (!this.message.equals(simpleMessage.message)) {
                return false;
            }
            return true;
        } else if (simpleMessage.message == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.message != null) {
            return this.message.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SimpleMessage[message=" + this.message + ']';
    }
}
