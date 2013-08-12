/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.journal.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.templateparser.TransformerListener;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Image;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.journal.NoSuchFolderException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.model.JournalFolder;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.portlet.journal.util.LocaleTransformerListener;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @author Wesley Gong
 */
public class JournalArticleImpl extends JournalArticleBaseImpl {

	public static String getContentByLocale(
		String content, boolean templateDriven, String languageId) {

		TransformerListener transformerListener =
			new LocaleTransformerListener();

		return transformerListener.onXml(content, languageId, null);
	}

	public JournalArticleImpl() {
	}

	@Override
	public String getArticleImageURL(ThemeDisplay themeDisplay) {
		if (!isSmallImage()) {
			return null;
		}

		if (Validator.isNotNull(getSmallImageURL())) {
			return getSmallImageURL();
		}

		return
			themeDisplay.getPathImage() + "/journal/article?img_id=" +
				getSmallImageId() + "&t=" +
					WebServerServletTokenUtil.getToken(getSmallImageId());
	}

	@Override
	public JournalArticleResource getArticleResource()
		throws PortalException, SystemException {

		return JournalArticleResourceLocalServiceUtil.getArticleResource(
			getResourcePrimKey());
	}

	@Override
	public String getArticleResourceUuid()
		throws PortalException, SystemException {

		JournalArticleResource articleResource = getArticleResource();

		return articleResource.getUuid();
	}

	@Override
	public String[] getAvailableLanguageIds() {

		Set<String> availableLanguageIds = SetUtil.fromArray(
			super.getAvailableLanguageIds());

		// Content

		String[] availableContentLanguageIdsArray =
			LocalizationUtil.getAvailableLanguageIds(getContent());

		for (String availableLanguageId : availableContentLanguageIdsArray) {
			availableLanguageIds.add(availableLanguageId);
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	/**
	 * @deprecated As of 6.2.0, replaced by {@link #getAvailableLanguageIds}
	 */
	@Override
	public String[] getAvailableLocales() {
		return getAvailableLanguageIds();
	}

	@Override
	public String getContentByLocale(String languageId) {
		return getContentByLocale(getContent(), isTemplateDriven(), languageId);
	}

	public String getDefaultLanguageId() {
		String defaultLanguageId = super.getDefaultLanguageId();

		if (isTemplateDriven() && Validator.isNull(defaultLanguageId)) {
			defaultLanguageId = LocaleUtil.toLanguageId(
				LocaleUtil.getSiteDefault());
		}

		return defaultLanguageId;
	}

	/**
	 * @deprecated As of 6.2.0, replaced by {@link #getDefaultLanguageId}
	 */
	@Override
	public String getDefaultLocale() {
		return getDefaultLanguageId();
	}

	@Override
	public JournalFolder getFolder() throws PortalException, SystemException {
		if (getFolderId() <= 0) {
			return new JournalFolderImpl();
		}

		return JournalFolderLocalServiceUtil.getFolder(getFolderId());
	}

	@Override
	public String getSmallImageType() throws PortalException, SystemException {
		if ((_smallImageType == null) && isSmallImage()) {
			Image smallImage = ImageLocalServiceUtil.getImage(
				getSmallImageId());

			_smallImageType = smallImage.getType();
		}

		return _smallImageType;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(JournalArticle.class);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		Locale defaultLocale = LocaleThreadLocal.getDefaultLocale();

		try {
			Locale articleDefaultLocale = LocaleUtil.fromLanguageId(
				getDefaultLocale());

			LocaleThreadLocal.setDefaultLocale(articleDefaultLocale);

			return super.getTitleMap();
		}
		finally {
			LocaleThreadLocal.setDefaultLocale(defaultLocale);
		}
	}

	@Override
	public JournalFolder getTrashContainer()
		throws PortalException, SystemException {

		JournalFolder folder = null;

		try {
			folder = getFolder();
		}
		catch (NoSuchFolderException nsfe) {
			return null;
		}

		if (folder.isInTrash()) {
			return folder;
		}

		return folder.getTrashContainer();
	}

	@Override
	public boolean isInTrashContainer()
		throws PortalException, SystemException {

		if (getTrashContainer() != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isTemplateDriven() {
		if (Validator.isNull(getStructureId())) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * @param  defaultImportLocale the default imported locale
	 * @throws LocaleException if a locale exception occurred
	 */
	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
	}

	@Override
	public void setSmallImageType(String smallImageType) {
		_smallImageType = smallImageType;
	}

	private String _smallImageType;

}