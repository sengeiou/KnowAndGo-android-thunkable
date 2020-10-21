package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.RefPicMarking */
public class RefPicMarking {
    private Instruction[] instructions;

    /* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.RefPicMarking$InstrType */
    public enum InstrType {
        REMOVE_SHORT,
        REMOVE_LONG,
        CONVERT_INTO_LONG,
        TRUNK_LONG,
        CLEAR,
        MARK_LONG
    }

    /* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.RefPicMarking$Instruction */
    public static class Instruction {
        private int arg1;
        private int arg2;
        private InstrType type;

        public Instruction(InstrType instrType, int i, int i2) {
            this.type = instrType;
            this.arg1 = i;
            this.arg2 = i2;
        }

        public int getArg1() {
            return this.arg1;
        }

        public int getArg2() {
            return this.arg2;
        }

        public InstrType getType() {
            return this.type;
        }
    }

    public RefPicMarking(Instruction[] instructionArr) {
        this.instructions = instructionArr;
    }

    public Instruction[] getInstructions() {
        return this.instructions;
    }
}
