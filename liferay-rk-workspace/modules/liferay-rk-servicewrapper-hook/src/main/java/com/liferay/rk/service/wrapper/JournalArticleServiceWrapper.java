package com.liferay.rk.service.wrapper;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.File;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    service = JournalArticleServiceWrapper.class
	)
public class JournalArticleServiceWrapper extends JournalArticleLocalServiceWrapper{

	public JournalArticleServiceWrapper() {
        super(null);
    }
	
	 @Override
	    public JournalArticle deleteJournalArticle(JournalArticle article) {
	        // Add custom logic here before deleting the article
	        System.out.println("Custom logic before deleting the article");

	        // Call the original service method
	        JournalArticle deletedArticle = super.deleteJournalArticle(article);

	        // Add custom logic here after deleting the article
	        System.out.println("Custom logic after deleting the article");

	        return deletedArticle;
	    }

	@Override
	public JournalArticle addArticle(long userId, long groupId, long folderId, long classNameId, long classPK,
			String articleId, boolean autoArticleId, double version, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> friendlyURLMap, String content,
			String ddmStructureKey, String ddmTemplateKey, String layoutUuid, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear, int expirationDateHour, int expirationDateMinute,
			boolean neverExpire, int reviewDateMonth, int reviewDateDay, int reviewDateYear, int reviewDateHour,
			int reviewDateMinute, boolean neverReview, boolean indexable, boolean smallImage, String smallImageURL,
			File smallImageFile, Map<String, byte[]> images, String articleURL, ServiceContext serviceContext)
			throws PortalException {
		  System.out.println("Custom logic before adding the article");
		return super.addArticle(userId, groupId, folderId, classNameId, classPK, articleId, autoArticleId, version, titleMap,
				descriptionMap, friendlyURLMap, content, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth,
				displayDateDay, displayDateYear, displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay,
				expirationDateYear, expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay,
				reviewDateYear, reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL,
				smallImageFile, images, articleURL, serviceContext);
	}

	    // You can override other methods as needed

}
