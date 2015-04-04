package org.jedynakd.app;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    private static final String RESULT_FILE = "result.png";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldCompareTwoImagesAndSaveResult() throws IOException {
        Application.main("src/test/resources/test1.png", "src/test/resources/test2.png");

        File result = new File(RESULT_FILE);
        assertThat(result).exists();
        File expectedResult = new File("src/test/resources/expectedResult.png");
        assertThat(result).hasContentEqualTo(expectedResult);

        cleanUp();
    }

    private void cleanUp() {
        File file = new File(RESULT_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void shouldThrowExceptionWhenNoArgumentsProvided() throws IOException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(Application.ERROR_MESSAGE);

        Application.main();
    }


}