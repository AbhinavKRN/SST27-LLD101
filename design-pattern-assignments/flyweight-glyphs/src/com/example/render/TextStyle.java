package com.example.render;

import java.util.Objects;

public final class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = Objects.requireNonNull(font, "font");
        this.size = size;
        this.bold = bold;
    }

    public String getFont() { return font; }
    public int getSize() { return size; }
    public boolean isBold() { return bold; }

    public int drawCost() { 
        return size + (bold ? 10 : 0); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextStyle that = (TextStyle) obj;
        return size == that.size && bold == that.bold && Objects.equals(font, that.font);
    }

    @Override
    public int hashCode() {
        return Objects.hash(font, size, bold);
    }

    @Override
    public String toString() {
        return font + "|" + size + "|" + (bold ? "B" : "N");
    }
}
