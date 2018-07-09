package com.UrlToFileDownload;

public class DownloaderApp {
    public static void main(String[] args) {
        String[] imagesToDownload = new String[] {
                "http://fbapp.itcuties.com/middle/_DSC4598.jpg",
                "http://www.gstatic.com/webp/gallery/1.jpg",
                "http://www.gstatic.com/webp/gallery/2.jpg",
                "http://www.gstatic.com/webp/gallery/3.jpg",
                "http://www.gstatic.com/webp/gallery/4.jpg",
                "http://www.gstatic.com/webp/gallery/5.jpg",
        };

        String destinationFolder = "C:\\temp\\imageDownload\\";

        // With single thread

        try {
            int nameIndex = 0;
            long startTime = 0;
            long endTime = 0;

            System.out.println("Downloading " + imagesToDownload.length + " images with single thread");

            startTime = System.currentTimeMillis();

            System.out.println(startTime);

            for (String url : imagesToDownload) {
                System.out.println(url);
                new ImageDownloader(url, destinationFolder).download();
            }

            endTime = System.currentTimeMillis();

            System.out.println("Downloading " + imagesToDownload.length + " took " + (endTime - startTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
