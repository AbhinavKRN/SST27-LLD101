package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;

    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter(new LegacySharpen());
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        // Step 1: Decode video to frames
        Frame[] frames = decoder.decode(src);

        // Step 2: Apply optional grayscale filter
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }

        // Step 3: Apply optional scale filter
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }

        // Step 4: Apply optional sharpen filter
        if (sharpenStrength != null && sharpenStrength > 0) {
            frames = sharpenAdapter.applySharpen(frames, sharpenStrength);
        }

        // Step 5: Encode frames to output video
        return encoder.encode(frames, out);
    }
}
