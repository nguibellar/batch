package org.devware.batch.reader;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
        
public class MultiBatchItemReader<T> extends MultiResourceItemReader<T> {

    private static final String COMMA = ",";
    
    Resource[] resources;

   
    String fileDirectory;
    
    @Override
    public void setResources(Resource[] resources) {
        
         // si le repertoire n est pas indiqué
         Assert.notNull(fileDirectory, "The Directory must not be null");
         
         List<Resource> pathlist = null;
        try {         
            // on recupere les fichiers
            pathlist = DirectoryList(fileDirectory,"xls,xlsx");
        
        } catch (IOException ex) {
                // si le repertoire n est pas indiqué
                Assert.notNull(fileDirectory, "The unable to open a file");  
        }
        
        // on verifie le path
        if (pathlist == null || pathlist.isEmpty())
                Assert.notNull(fileDirectory, "No resource in fileDirectory");
        
        // on initialise la ressource    
        this.resources = pathlist.toArray(new Resource[pathlist.size()+1]);
    }
    
    
    public static List<Resource> DirectoryList(String path, String csvList) throws IOException{
        
        // on definie la liste
        List<Resource> pathList = new ArrayList<Resource>();
        
        // si la chaine est null ou vide
        if (path == null || path.isEmpty()) return null;
        
        // on recupere le path à partir du string
        Path innerPath = Paths.get(path);
        
        // on recupere le fichier excel
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(innerPath,"*.{"+csvList+"}")) {
            
            // on creer une collection de resources 
            for (Path entry : stream) {
                 pathList.add(new FileSystemResource(entry.toFile().getAbsoluteFile()));
            }
        }
        
        // on retourne la liste
        return pathList;
    }
    
    public static String stringToCsv (List<String> listString){
        
        String csvList = new String("");
        
        // on verifie la liste de String
        if (listString == null || listString.isEmpty()) return csvList;
        
        // 
        for (String chaine:listString){ 
            // 
            csvList = chaine.trim() +  COMMA + csvList;
        }
        
        // on retourne la chaine csv
        return csvList;
    }
    
     public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }
   

}
