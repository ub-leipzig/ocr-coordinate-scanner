/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.ubleipzig.metadata.scanner;

import java.util.List;

import org.xmlbeam.annotation.XBRead;

/**
 * HocrData.
 *
 * @author Christopher Johnson
 */
public interface HocrData {
    /**
     * getPageNodeId.
     *
     * @return PageNodeId
     */
    @XBRead("//*[local-name()='div'][@class='ocr_page']/@id")
    List<String> getPageNodeId();

    /**
     * getCAreaNodeId.
     *
     * @return CAreaNodeId
     */
    @XBRead("//*[local-name()='div'][@class='ocr_carea']/@id")
    List<String> getCAreaNodeId();

    /**
     * getLineNodeId.
     *
     * @return LineNodeId
     */
    @XBRead("//*[local-name()='span'][@class='ocr_line']/@id")
    List<String> getLineNodeId();

    /**
     * getWordNodeId.
     *
     * @return WordNodeId
     */
    @XBRead("//*[local-name()='span'][@class='ocrx_word']/@id")
    List<String> getWordNodeId();

    /**
     * getCAreasforPage.
     *
     * @param id String
     * @return CAreasforPage
     */
    @XBRead("//*[local-name()='div'][@class='ocr_page'][@id='{0}']/descendant::node()"
            + "[@class='ocr_carea']/@id")
    List<String> getCAreasforPage(String id);

    /**
     * getLinesforArea.
     *
     * @param id String
     * @return LinesforArea
     */
    @XBRead("//*[local-name()='div'][@class='ocr_carea'][@id='{0}']/descendant::node()"
            + "[@class='ocr_line']/@id")
    List<String> getLinesforArea(String id);

    /**
     * getWordsforLine.
     *
     * @param id String
     * @return WordsforLine
     */
    @XBRead("//*[local-name()='span'][@class='ocr_line'][@id='{0}']/descendant::node()"
            + "[@class='ocrx_word']/@id")
    List<String> getWordsforLine(String id);

    /**
     * getWordsforPage.
     *
     * @param id String
     * @return WordsforPage
     */
    @XBRead("//*[local-name()='div'][@class='ocr_page'][@id='{0}']/descendant::node()"
            + "[@class='ocrx_word']/@id")
    List<String> getWordsforPage(String id);

    /**
     * getCAreaIdDescIds.
     *
     * @param id String
     * @return CAreaIdDescIds
     */
    @XBRead("//*[local-name()='div'][@class='ocr_carea'][@id='{0}']/descendant::node()/@id")
    List<String> getCAreaIdDescIds(String id);

    /**
     * getTitleForId.
     *
     * @param id String
     * @return TitleForId
     */
    @XBRead("//*[@id='{0}']/@title")
    String getTitleForId(String id);

    /**
     * getCharsForId.
     *
     * @param id String
     * @return CharsForId
     */
    @XBRead("//*[@id='{0}']//text()")
    String getCharsForId(String id);

}
