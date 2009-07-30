/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.social.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="SocialActivityPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    SocialActivityPersistenceImpl
 * @see    SocialActivityUtil
 * @generated
 */
public interface SocialActivityPersistence extends BasePersistence {
	public void cacheResult(
		com.liferay.portlet.social.model.SocialActivity socialActivity);

	public void cacheResult(
		java.util.List<com.liferay.portlet.social.model.SocialActivity> socialActivities);

	public void clearCache();

	public com.liferay.portlet.social.model.SocialActivity create(
		long activityId);

	public com.liferay.portlet.social.model.SocialActivity remove(
		long activityId)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity remove(
		com.liferay.portlet.social.model.SocialActivity socialActivity)
		throws com.liferay.portal.SystemException;

	/**
	 * @deprecated Use {@link #update(SocialActivity, boolean merge)}.
	 */
	public com.liferay.portlet.social.model.SocialActivity update(
		com.liferay.portlet.social.model.SocialActivity socialActivity)
		throws com.liferay.portal.SystemException;

	/**
	 * Add, update, or merge, the entity. This method also calls the model
	 * listeners to trigger the proper events associated with adding, deleting,
	 * or updating an entity.
	 *
	 * @param  socialActivity the entity to add, update, or merge
	 * @param  merge boolean value for whether to merge the entity. The default
	 *         value is false. Setting merge to true is more expensive and
	 *         should only be true when socialActivity is transient. See
	 *         LEP-5473 for a detailed discussion of this method.
	 * @return the entity that was added, updated, or merged
	 */
	public com.liferay.portlet.social.model.SocialActivity update(
		com.liferay.portlet.social.model.SocialActivity socialActivity,
		boolean merge) throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity updateImpl(
		com.liferay.portlet.social.model.SocialActivity socialActivity,
		boolean merge) throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByPrimaryKey(
		long activityId)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity fetchByPrimaryKey(
		long activityId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByGroupId(
		long groupId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByGroupId_First(
		long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByGroupId_Last(
		long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity[] findByGroupId_PrevAndNext(
		long activityId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByCompanyId(
		long companyId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByCompanyId_First(
		long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByCompanyId_Last(
		long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity[] findByCompanyId_PrevAndNext(
		long activityId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByUserId(
		long userId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByUserId_First(
		long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByUserId_Last(
		long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity[] findByUserId_PrevAndNext(
		long activityId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByMirrorActivityId(
		long mirrorActivityId)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity fetchByMirrorActivityId(
		long mirrorActivityId) throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity fetchByMirrorActivityId(
		long mirrorActivityId, boolean retrieveFromCache)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByClassNameId(
		long classNameId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByClassNameId(
		long classNameId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByClassNameId(
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByClassNameId_First(
		long classNameId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByClassNameId_Last(
		long classNameId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity[] findByClassNameId_PrevAndNext(
		long activityId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByReceiverUserId(
		long receiverUserId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByReceiverUserId(
		long receiverUserId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByReceiverUserId(
		long receiverUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByReceiverUserId_First(
		long receiverUserId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByReceiverUserId_Last(
		long receiverUserId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity[] findByReceiverUserId_PrevAndNext(
		long activityId, long receiverUserId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByC_C(
		long classNameId, long classPK)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByC_C(
		long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByC_C(
		long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByC_C_First(
		long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByC_C_Last(
		long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity[] findByC_C_PrevAndNext(
		long activityId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByM_C_C(
		long mirrorActivityId, long classNameId, long classPK)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByM_C_C(
		long mirrorActivityId, long classNameId, long classPK, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findByM_C_C(
		long mirrorActivityId, long classNameId, long classPK, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity findByM_C_C_First(
		long mirrorActivityId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByM_C_C_Last(
		long mirrorActivityId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity[] findByM_C_C_PrevAndNext(
		long activityId, long mirrorActivityId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity findByG_U_CD_C_C_T_R(
		long groupId, long userId, long createDate, long classNameId,
		long classPK, int type, long receiverUserId)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public com.liferay.portlet.social.model.SocialActivity fetchByG_U_CD_C_C_T_R(
		long groupId, long userId, long createDate, long classNameId,
		long classPK, int type, long receiverUserId)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.social.model.SocialActivity fetchByG_U_CD_C_C_T_R(
		long groupId, long userId, long createDate, long classNameId,
		long classPK, int type, long receiverUserId, boolean retrieveFromCache)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.social.model.SocialActivity> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByGroupId(long groupId)
		throws com.liferay.portal.SystemException;

	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(long userId)
		throws com.liferay.portal.SystemException;

	public void removeByMirrorActivityId(long mirrorActivityId)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public void removeByClassNameId(long classNameId)
		throws com.liferay.portal.SystemException;

	public void removeByReceiverUserId(long receiverUserId)
		throws com.liferay.portal.SystemException;

	public void removeByC_C(long classNameId, long classPK)
		throws com.liferay.portal.SystemException;

	public void removeByM_C_C(long mirrorActivityId, long classNameId,
		long classPK) throws com.liferay.portal.SystemException;

	public void removeByG_U_CD_C_C_T_R(long groupId, long userId,
		long createDate, long classNameId, long classPK, int type,
		long receiverUserId)
		throws com.liferay.portal.SystemException,
			com.liferay.portlet.social.NoSuchActivityException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByGroupId(long groupId)
		throws com.liferay.portal.SystemException;

	public int countByCompanyId(long companyId)
		throws com.liferay.portal.SystemException;

	public int countByUserId(long userId)
		throws com.liferay.portal.SystemException;

	public int countByMirrorActivityId(long mirrorActivityId)
		throws com.liferay.portal.SystemException;

	public int countByClassNameId(long classNameId)
		throws com.liferay.portal.SystemException;

	public int countByReceiverUserId(long receiverUserId)
		throws com.liferay.portal.SystemException;

	public int countByC_C(long classNameId, long classPK)
		throws com.liferay.portal.SystemException;

	public int countByM_C_C(long mirrorActivityId, long classNameId,
		long classPK) throws com.liferay.portal.SystemException;

	public int countByG_U_CD_C_C_T_R(long groupId, long userId,
		long createDate, long classNameId, long classPK, int type,
		long receiverUserId) throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}