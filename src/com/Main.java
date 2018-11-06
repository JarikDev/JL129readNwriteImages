package com;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("smile.jpg");
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "png", new File("smile.png"));

        String[] extensions = ImageIO.getReaderFileSuffixes();
        for (String str : extensions) {
            System.out.println(str);
        }

        ImageReader reader = null;
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("JPEG");
        if (iterator.hasNext()) reader = iterator.next();

        InputStream inputStream = new FileInputStream(new File("smile.jpg"));
        ImageInputStream iis = ImageIO.createImageInputStream(inputStream);
       ImageInputStream iis2 = ImageIO.createImageInputStream(new File("smile.jpg"));
        reader.setInput(iis, true);
        BufferedImage image1 = reader.read(reader.getNumImages(true));

        int count = reader.getNumThumbnails(0);
        BufferedImage image2 = reader.readThumbnail(0, count);
        System.out.println(reader.getHeight(0));
        reader.getWidth(0);

        ImageWriter writer = null;
        Iterator<ImageWriter> iterator1 = ImageIO.getImageWritersByFormatName("JPEG");
        if (iterator1.hasNext()) writer = iterator1.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(new File("smile.png"));
        writer.setOutput(ios);


    }
}
