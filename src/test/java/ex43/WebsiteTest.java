package ex43;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteTest {

    @Test
    void createFile() {
        File f = Website.createFile("./website/");
        assert f != null;
    }

    @Test
    void testCreateFile() {
        File f = Website.createFile("./website/index.html");
        assert f != null;
    }

}