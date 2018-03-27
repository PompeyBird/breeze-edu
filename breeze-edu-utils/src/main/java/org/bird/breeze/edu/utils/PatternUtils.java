package org.bird.breeze.edu.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author pompey
 */
@Component
public class PatternUtils {
    static Pattern starPtn = Pattern.compile("\\*");
//    private Set<String> rules = new HashSet<String>();
//    private List<String> ptns = new ArrayList<String>();

    private Pattern getPattern(List<String> patterns) {
        StringBuilder sb = new StringBuilder();
        int size = patterns.size();
        if (size > 0) {
            sb.append("(").append(patterns.get(0)).append(")");
        }
        for (int i = 1; i < size; i++) {
            sb.append("|(").append(patterns.get(i)).append(")");
        }
        return Pattern.compile(sb.toString());
    }

    private void add(String rule, Set<String> rules, List<String> patterns) {
        if (StringUtils.isNotBlank(rule) && rules.add(rule)) {
            String[] stars = starPtn.split(rule, -1);
            if (stars.length > 1) {
                StringBuilder regex = new StringBuilder();
                for (int i = 0; i < stars.length - 1; i++) {
                    if ("".equals(stars[i])) {
                        if ("".equals(stars[i + 1])) {
                            regex.append(".*");
                            i++;
                        } else {
                            regex.append("[^/]*");
                        }
                    } else {
                        regex.append(Pattern.quote(stars[i]));
                    }
                }
                if ("".equals(stars[stars.length - 1])) {
                    regex.append("[^/]*");
                } else {
                    regex.append(Pattern.quote(stars[stars.length - 1]));
                }
                patterns.add(regex.toString());
            } else {
                patterns.add(Pattern.quote(stars[0]));
            }
        }
    }

    public Pattern build(String rules) {
        Set<String> patternRules = new HashSet<String>();
        List<String> patterns = new ArrayList<String>();
        if (StringUtils.isNotBlank(rules)) {
            String[] u = rules.split("[,; ]");
            for (String rule : u) {
                add(rule, patternRules, patterns);
            }
            return getPattern(patterns);
        } else {
            return null;
        }
    }
}
