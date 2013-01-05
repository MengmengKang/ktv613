package com.xch.server;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Chinese2Pinyin
{
    String chinese;

    public Chinese2Pinyin(final String songName)
    {
        chinese = songName;
    }

    public String getPinyin()
    {
        String res = new String("");
        for (int i = 0; i < chinese.length(); i++)
        {
            final char chineseCharacter = chinese.charAt(i);
            final HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
            outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            outputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
            outputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
            String[] pinyinArray = null;
            try
            {
                pinyinArray = PinyinHelper.toHanyuPinyinStringArray(
                        chineseCharacter, outputFormat);
            }
            catch (final BadHanyuPinyinOutputFormatCombination e1)
            {
                e1.printStackTrace();
            }
            if (pinyinArray != null)
            {
                res = res
                        .concat(String.valueOf(pinyinArray[0].substring(0, 1)));
            }
        }
        return res;
    }
}
