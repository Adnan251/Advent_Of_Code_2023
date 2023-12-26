package org.example.Day24;

public class Ice {
    private long x;
    private long y;
    private long z;
    private int velocityX;
    private int velocityY;
    private int velocityZ;

    public Ice(String string){
        String[] firstSplit = string.split("@");
        String[] f1 = firstSplit[0].trim().split(", ");
        this.x = Long.parseLong(f1[0].trim());
        this.y = Long.parseLong(f1[1].trim());
        this.z = Long.parseLong(f1[2].trim());
        String[] f2 = firstSplit[1].trim().split(", ");
        this.velocityX = Integer.parseInt(f2[0].trim());
        this.velocityY = Integer.parseInt(f2[1].trim());
        this.velocityZ = Integer.parseInt(f2[2].trim());
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getVelocityZ() {
        return velocityZ;
    }

    public String toString(){
        return "(" + this.x + ", " + this.y + ", " + this.z + ") => ("+ velocityX + ", " + velocityY + ", " +velocityZ + ")" ;
    }
}
