package com.breakingbad;

import com.breakingbad.spi.Developer;

import java.io.IOException;
import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ServiceLoader<Developer> load = ServiceLoader.load(Developer.class);
        for (Developer developer: load){
            developer.coding();
        }
    }
}
