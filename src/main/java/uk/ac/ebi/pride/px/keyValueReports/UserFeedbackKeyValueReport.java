package uk.ac.ebi.pride.px.keyValueReports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.px.UserFeedbackReport;
import uk.ac.ebi.pride.px.reports.ReportBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: libpxreport
 * Package: uk.ac.ebi.pride.px
 * Timestamp: 2016-05-03 13:57
 * ---
 * © 2016 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
public class UserFeedbackKeyValueReport extends KeyValueReport implements UserFeedbackReport {
    private static final Logger logger = LoggerFactory.getLogger(UserFeedbackKeyValueReport.class);

    // Model keys
    private static final String KEY_RATING = "userFeedbackRating";
    private static final String KEY_COMMENT = "userFeedbackComments";

    // Getters and setters


    public UserFeedbackKeyValueReport() {
        storeKeyValuePair(KEY_COMMENT, "--- no comment provided ---");
    }

    public void setRating(int rating) {
        logger.debug("Setting user feedback rating to " + rating);
        storeKeyValuePair(KEY_RATING, Integer.toString(rating));
    }

    public void setComments(String comments) {
        logger.debug("Setting user comments '" + comments + "'");
        storeKeyValuePair(KEY_COMMENT, comments);
    }

    public int getRating() {
        return new Integer(getValueForKey(KEY_RATING)).intValue();
    }

    public String getComments() {
        return getValueForKey(KEY_COMMENT);
    }

    List<String> getKeys() {
        List<String> keyList = new ArrayList<String>();
        keyList.add(KEY_RATING);
        keyList.add(KEY_COMMENT);
        logger.debug("User feedback list of keys: " + keyList.toString());
        return keyList;
    }

    @Override
    public boolean save(ReportBuilder builder) {
        logger.debug("Saving user's feedback");
        return super.save(builder);
    }
}

