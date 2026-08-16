package library.model;

public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;
    private static String libraryName = "Central Smart Library";
    private static int totalResources = 0;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResources++;
    }

    public int getResourceId() { return resourceId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    
    public static String getLibraryName() { return libraryName; }
    
    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + totalResources);
    }
    
    // Protected method example to be used by subclasses
    protected void displayBaseInfo() {
        System.out.print("ID: " + resourceId + " | Title: " + title + " | Author: " + author);
    }

    public abstract double calculateFine(int overdueDays);
}