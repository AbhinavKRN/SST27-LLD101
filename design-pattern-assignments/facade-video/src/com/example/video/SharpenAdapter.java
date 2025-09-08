package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen");
    }

    public Frame[] applySharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        
        // Convert frames to a handle string (simulate frame handles)
        String framesHandle = "FRAMES:" + frames.length + ":" + 
                             (frames.length > 0 ? frames[0].w + "x" + frames[0].h : "0x0");
        
        // Apply legacy sharpen
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);
        
        // Return the same frames (in a real implementation, this would process the frames)
        // For this simulation, we just return the input frames
        return frames;
    }
}
