package org.jedynakd.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.image.BufferedImage;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ImageUtilityTest {

    private ImageUtility imageUtility = new ImageUtility();
    @Mock
    private BufferedImage image;

    @Test
    public void shouldReturnPixelsRGBValue() {
        int width = 2;
        int height = 1;
        int rgbPointOne = 12;
        int rgbPointTwo = 13;
        given(image.getWidth()).willReturn(width);
        given(image.getHeight()).willReturn(height);
        given(image.getRGB(0, 0)).willReturn(rgbPointOne);
        given(image.getRGB(1, 0)).willReturn(rgbPointTwo);

        List<Integer> result = imageUtility.getImageRGBValueOfPixels(image);

        assertThat(result).containsExactly(rgbPointOne, rgbPointTwo);
    }

}