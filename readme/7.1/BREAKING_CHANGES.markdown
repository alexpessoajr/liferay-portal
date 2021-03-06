# What are the Breaking Changes for Liferay 7.1?

This document presents a chronological list of changes that break existing
functionality, APIs, or contracts with third party Liferay developers or users.
We try our best to minimize these disruptions, but sometimes they are
unavoidable.

Here are some of the types of changes documented in this file:

* Functionality that is removed or replaced
* API incompatibilities: Changes to public Java or JavaScript APIs
* Changes to context variables available to templates
* Changes in CSS classes available to Liferay themes and portlets
* Configuration changes: Changes in configuration files, like
  `portal.properties`, `system.properties`, etc.
* Execution requirements: Java version, J2EE Version, browser versions, etc.
* Deprecations or end of support: For example, warning that a certain
  feature or API will be dropped in an upcoming version.
* Recommendations: For example, recommending using a newly introduced API that
  replaces an old API, in spite of the old API being kept in Liferay Portal for
  backwards compatibility.

*This document has been reviewed through commit `868fe06cbf30`.*

## Breaking Changes Contribution Guidelines

Each change must have a brief descriptive title and contain the following
information:

* **[Title]** Provide a brief descriptive title. Use past tense and follow
  the capitalization rules from
  <http://en.wikibooks.org/wiki/Basic_Book_Design/Capitalizing_Words_in_Titles>.
* **Date:** Specify the date you submitted the change. Format the date as
  *YYYY-MMM* (e.g., 2014-Mar) or *YYYY-MMM-DD* (e.g., 2014-Feb-25).
* **JIRA Ticket:** Reference the related JIRA ticket (e.g., LPS-123456)
  (Optional).
* **What changed?** Identify the affected component and the type of change that
  was made.
* **Who is affected?** Are end-users affected? Are developers affected? If the
  only affected people are those using a certain feature or API, say so.
* **How should I update my code?** Explain any client code changes required.
* **Why was this change made?** Explain the reason for the change. If
  applicable, justify why the breaking change was made instead of following a
  deprecation process.

Here's the template to use for each breaking change (note how it ends with a
horizontal rule):

```
### Title
- **Date:**
- **JIRA Ticket:**

#### What changed?

#### Who is affected?

#### How should I update my code?

#### Why was this change made?

---------------------------------------
```

**80 Columns Rule:** Text should not exceed 80 columns. Keeping text within 80
columns makes it easier to see the changes made between different versions of
the document. Titles, links, and tables are exempt from this rule. Code samples
must follow the column rules specified in Liferay's
[Development Style](http://www.liferay.com/community/wiki/-/wiki/Main/Liferay+development+style).

The remaining content of this document consists of the breaking changes listed
in ascending chronological order.

## Breaking Changes List

### Standardized Data Attribute Names Passed into Selectors
- **Date:** 2016-Oct-26
- **JIRA Ticket:** LPS-66646

#### What changed?

The data attributes passed into the event when someone uses a selector (e.g.,
asset selector, document selector, file selector, role selector, site selector,
user group selector, etc.) have been standardized from being selector specific
(e.g., `groupid`, `groupdescriptivename`, `teamid`, `teamname`, etc.) to being
more generic (e.g., `entityid` and `entityname`).

#### Who is affected?

This affects anyone passing selector specific data attributes to a selector.

#### How should I update my code?

Instead of using selector specific data attributes, you should change your data
attributes to use `entityid` and `entityname`.

**Example**

Old way:

    <portlet:namespace />selectFileEntryType(event.fileentrytypeid, event.fileentrytypename);

New way:

    <portlet:namespace />selectFileEntryType(event.entityid, event.entityname);

Old way:

    data.put("roleid", role.getRoleId());
    data.put("roletitle", role.getTitle(locale));

New way:

    data.put("entityid", role.getRoleId());
    data.put("entityname", role.getTitle(locale));

#### Why was this change made?

This change was made to standardize the data attribute names and allow utility
methods to accept standardized event parameters.

---------------------------------------

### Removed URL Parameters p_p_col_id, p_p_col_pos, and p_p_col_count from Every Portlet URL.
- **Date:** 2016-Dec-12
- **JIRA Ticket:** LPS-69482

#### What changed?

The parameters `p_p_col_count`, `p_p_col_id`, and `p_p_col_pos` are no longer
present in every portlet URL.

#### Who is affected?

This affects developers who are reading these parameters in their custom code.

#### How should I update my code?

You can no longer obtain these parameters from the portlet URL. If you need to
read them, you should do it from `PortletDisplay`.

- The parameter `p_p_col_count` can be obtained via the
  `portletDisplay.getColumnCount()` method.
- The parameter `p_p_col_id` can be obtained via the
  `portletDisplay.getColumnId()` method.
- The parameter `p_p_col_pos` can be obtained via the
  `portletDisplay.getColumnPos()` method.

#### Why was this change made?

This change simplifies portlet URLs so they only contain the required
parameters. This was done as a preliminary step of a bigger story to create
portlet URLs without passing the request as a necessary parameter.

---------------------------------------

### Moved Users File Uploads Portlet Properties to OSGi Configuration
- **Date:** 2017-Feb-06
- **JIRA Ticket:** LPS-69211

#### What changed?

The Users File Uploads portlet properties have been moved from Server
Administration to an OSGI configuration named
`UserFileUploadsConfiguration.java` in the `users-admin-api` module.

#### Who is affected?

This affects anyone using the following portlet properties:

- `users.image.check.token`
- `users.image.max.size`
- `users.image.max.height`
- `users.image.max.width`

#### How should I update my code?

Instead of overriding the `portal.properties` file, you can manage the
properties from Portal's configuration administrator. This can be accessed by
navigating to Liferay Portal's *Control Panel* &rarr; *Configuration* &rarr;
*System Settings* &rarr; *Foundation* &rarr; *User Images* and editing the
settings there.

If you would like to include the new configuration in your application, follow
the instructions for
[making your applications configurable in Liferay 7.0](https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/making-your-applications-configurable).

#### Why was this change made?

This change was made as part of the modularization efforts to ease portal
configuration changes.

---------------------------------------

### Moved CAPTCHA Portal Properties to OSGi Configuration
- **Date:** 2017-Feb-13
- **JIRA Ticket:** LPS-67830

#### What changed?

The CAPTCHA properties have been moved from `portal.properties` and Server
Administration to an OSGi configuration named `CaptchaConfiguration.java` in the
`captcha-api` module.

#### Who is affected?

This affects anyone using the following portal properties:

- `captcha.max.challenges`
- `captcha.check.portal.create_account`
- `captcha.check.portal.send_password`
- `captcha.check.portlet.message_boards.edit_category`
- `captcha.check.portlet.message_boards.edit_message`
- `captcha.engine.impl`
- `captcha.engine.recaptcha.key.private`
- `captcha.engine.recaptcha.key.public`
- `captcha.engine.recaptcha.url.script`
- `captcha.engine.recaptcha.url.noscript`
- `captcha.engine.recaptcha.url.verify`
- `captcha.engine.simplecaptcha.height`
- `captcha.engine.simplecaptcha.width`
- `captcha.engine.simplecaptcha.background.producers`
- `captcha.engine.simplecaptcha.gimpy.renderers`
- `captcha.engine.simplecaptcha.noise.producers`
- `captcha.engine.simplecaptcha.text.producers`
- `captcha.engine.simplecaptcha.word.renderers`

#### How should I update my code?

Instead of overriding the `portal.properties` file, you can manage the
properties from Portal's configuration administrator. This can be accessed by
navigating to Liferay Portal's *Control Panel* &rarr; *Configuration* &rarr;
*System Settings* &rarr; *Captcha* and editing the settings there.

If you would like to include the new configuration in your application, follow
the instructions for
[making your applications configurable in Liferay 7.0](https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/making-your-applications-configurable).

#### Why was this change made?

This change was made as part of the modularization efforts to ease portal
configuration changes.

---------------------------------------

### Moved OpenOffice Properties to OSGi Configuration
- **Date:** 2017-March-24
- **JIRA Ticket:** LPS-71382

#### What changed?

The OpenOffice properties have been moved from Server Administration to an OSGi
configuration named `OpenOfficeConfiguration.java` in the
`document-library-document-conversion` module.

#### Who is affected?

This affects anyone using the following portal properties:

- `openoffice.cache.enabled`
- `openoffice.server.enabled`
- `openoffice.server.host`
- `openoffice.server.port`

#### How should I update my code?

Instead of overriding the `portal.properties` file, you can manage the
properties from Portal's configuration administrator. This can be accessed by
navigating to Liferay Portal's *Control Panel* &rarr; *Configuration* &rarr;
*System Settings* &rarr; *Other* &rarr; *OpenOffice Integration* and editing the
settings there.

If you would like to include the new configuration in your application, follow
the instructions for
[making your applications configurable in Liferay 7.0](https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/making-your-applications-configurable).

#### Why was this change made?

This change was made as part of the modularization efforts to ease portal
configuration changes.

---------------------------------------

### Removed Indexation of Fields ratings and viewCount
- **Date:** 2017-May-16
- **JIRA Ticket:** LPS-70724

#### What changed?

The fields `ratings` and `viewCount` are no longer indexed in the `BaseIndexer`
class for `AssetEntry` objects.

#### Who is affected?

This affects any search-related custom code where the `ratings` and `viewCount`
fields are used in queries.

#### How should I update my code?

To adapt to these changes, consider several alternatives:

 - Use the Highest Rated Assets and Most Viewed Assets Liferay portlets.
 - Replace the index query with a database query.
 - Implement an `IndexerPostProcessor` to index these fields in certain
   documents.

#### Why was this change made?

Keeping the Ratings and View Count options in the search index in sync with the
database has a negative impact on normal operations due to the significantly
increased number of index Write requests causing throughput issues and,
therefore, performance degradation.

In addition, the view count is not always up-to-date in the database. This
behavior is controlled by the *Buffered Increment* mechanism. You can find
more information about this in the `portal.properties` file.

---------------------------------------

### Moved Upload Servlet Request Portal Properties to OSGi Configuration
- **Date:** 2017-May-30
- **JIRA Ticket:** LPS-69102

#### What changed?

The Upload Servlet Request properties have been moved from the
`portal.properties` file and Server Administration to an OSGi configuration
named `UploadServletRequestConfiguration.java` in the `portal-upload` module.

#### Who is affected?

This affects anyone using the following portal properties:

- `com.liferay.portal.upload.UploadServletRequestImpl.max.size`
- `com.liferay.portal.upload.UploadServletRequestImpl.temp.dir`

#### How should I update my code?

Instead of overriding the `portal.properties` file, you can manage the
properties from Portal's configuration administrator. This can be accessed by
navigating to Liferay Portal's *Control Panel* &rarr; *Configuration* &rarr;
*System Settings* &rarr; *Upload Servlet Request* and editing the settings
there.

If you would like to include the new configuration in your application, follow
the instructions for
[making your applications configurable in Liferay 7.0](https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/making-your-applications-configurable).

#### Why was this change made?

This change was made as part of the modularization efforts to ease portal
configuration changes.

---------------------------------------

### Removed the soyutils Module
- **Date:** 2017-Aug-28
- **JIRA Ticket:** LPS-69102

#### What changed?

The module `frontend-js-soyutils-web` is no longer available.

#### Who is affected?

This affects anyone using the `soyutils` module.

#### How should I update my code?

In the rare case that a component is affected, it is recommended that the code
is migrated to use the `metal-soy` module instead. You can do this by extending
the `Metal.js` provided `Component` classes.

#### Why was this change made?

The removed module exposed a legacy version of `soyutils`. This caused
interoperability issues between applications using different versions of the
Closure Template library.

---------------------------------------

### Changed default value for browser cache properties
- **Date:** 2017-Sep-05
- **JIRA Ticket:** LPS-74452

#### What changed?

The default values for the portal properties `browser.cache.disabled` and
`browser.cache.signed.in.disabled` were changed to `true`.

#### Who is affected?

This affects everyone who was relying on proxies and load balancers to cache
HTML content.

#### How should I update my code?

As documented in `portal-legacy-7.0.properties`, you should set
`browser.cache.disabled=false` and `browser.cache.signed.in.disabled=false`.

#### Why was this change made?

How a load balancer or web proxy should behave when Cache-Control headers are
missing is not defined. In the past, many preferred to err on the side of
not caching the content for correctness, but it is increasingly common for them
to err on the side of caching the content for performance.

As Liferay shifts towards use cases providing personalized experiences, then
whenever an aggressively caching load balancer or web proxy appears in the
network architecture, the default value may result in security problems such as
personalized content for one user being seen by another user, including names or
other personally identifiable information.

While this is ultimately a load balancer or web proxy configuration issue, it
is perceived as a Liferay issue because it is Liferay content that is being
cached, and is viewed very negatively because leaking sensitive information in a
production environment is a very serious security issue.

A value of `true` will improve a portal administrator's experience, and a value
of `false` can be considered during performance tuning, if needed.

---------------------------------------