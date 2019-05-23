package com.github.user.database


import androidx.annotation.Nullable
import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.savedroid.wish.database.BaseDao
import org.jetbrains.annotations.NotNull

@Entity
data class Repo(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @ColumnInfo(name = "stargazersCount")
    @Nullable
    @SerializedName("stargazers_count")
    var stargazersCount: Int = 0,

    @ColumnInfo(name = "pushedAt")
    @Nullable
    @SerializedName("pushed_at")
    var pushedAt: String = "",

    @ColumnInfo(name = "subscriptionUrl")
    @Nullable
    @SerializedName("subscription_url")
    var subscriptionUrl: String = "",

    @ColumnInfo(name = "language")
    @Nullable
    @SerializedName("language")
    var language: String = "",

    @ColumnInfo(name = "branchesUrl")
    @Nullable
    @SerializedName("branches_url")
    var branchesUrl: String = "",

    @ColumnInfo(name = "issueCommentUrl")
    @Nullable
    @SerializedName("issue_comment_url")
    var issueCommentUrl: String = "",

    @ColumnInfo(name = "labelsUrl")
    @Nullable
    @SerializedName("labels_url")
    var labelsUrl: String = "",

    @ColumnInfo(name = "subscribersUrl")
    @Nullable
    @SerializedName("subscribers_url")
    var subscribersUrl: String = "",

    @ColumnInfo(name = "releasesUrl")
    @Nullable
    @SerializedName("releases_url")
    var releasesUrl: String = "",

    @ColumnInfo(name = "svnUrl")
    @Nullable
    @SerializedName("svn_url")
    var svnUrl: String = "",

    @ColumnInfo(name = "id")
    @Nullable
    @SerializedName("id")
    var id: Int = 0,

    @ColumnInfo(name = "forks")
    @Nullable
    @SerializedName("forks")
    var forks: Int = 0,

    @ColumnInfo(name = "archiveUrl")
    @Nullable
    @SerializedName("archive_url")
    var archiveUrl: String = "",

    @ColumnInfo(name = "gitRefsUrl")
    @Nullable
    @SerializedName("git_refs_url")
    var gitRefsUrl: String = "",

    @ColumnInfo(name = "forksUrl")
    @Nullable
    @SerializedName("forks_url")
    var forksUrl: String = "",

    @ColumnInfo(name = "statusesUrl")
    @Nullable
    @SerializedName("statuses_url")
    var statusesUrl: String = "",

    @ColumnInfo(name = "sshUrl")
    @Nullable
    @SerializedName("ssh_url")
    var sshUrl: String = "",

    @ColumnInfo(name = "fullName")
    @Nullable
    @SerializedName("full_name")
    var fullName: String = "",

    @ColumnInfo(name = "size")
    @Nullable
    @SerializedName("size")
    var size: Int = 0,

    @ColumnInfo(name = "languagesUrl")
    @Nullable
    @SerializedName("languages_url")
    var languagesUrl: String = "",

    @ColumnInfo(name = "htmlUrl")
    @Nullable
    @SerializedName("html_url")
    var htmlUrl: String = "",

    @ColumnInfo(name = "collaboratorsUrl")
    @Nullable
    @SerializedName("collaborators_url")
    var collaboratorsUrl: String = "",

    @ColumnInfo(name = "cloneUrl")
    @Nullable
    @SerializedName("clone_url")
    var cloneUrl: String = "",

    @ColumnInfo(name = "name")
    @Nullable
    @SerializedName("name")
    var name: String = "",

    @ColumnInfo(name = "pullsUrl")
    @Nullable
    @SerializedName("pulls_url")
    var pullsUrl: String = "",

    @ColumnInfo(name = "defaultBranch")
    @Nullable
    @SerializedName("default_branch")
    var defaultBranch: String = "",

    @ColumnInfo(name = "hooksUrl")
    @Nullable
    @SerializedName("hooks_url")
    var hooksUrl: String = "",

    @ColumnInfo(name = "treesUrl")
    @Nullable
    @SerializedName("trees_url")
    var treesUrl: String = "",

    @ColumnInfo(name = "tagsUrl")
    @Nullable
    @SerializedName("tags_url")
    var tagsUrl: String = "",

    @ColumnInfo(name = "private")
    @Nullable
    @SerializedName("private")
    var private: Boolean = false,

    @ColumnInfo(name = "contributorsUrl")
    @Nullable
    @SerializedName("contributors_url")
    var contributorsUrl: String = "",

    @ColumnInfo(name = "hasDownloads")
    @Nullable
    @SerializedName("has_downloads")
    var hasDownloads: Boolean = false,

    @ColumnInfo(name = "notificationsUrl")
    @Nullable
    @SerializedName("notifications_url")
    var notificationsUrl: String = "",

    @ColumnInfo(name = "openIssuesCount")
    @Nullable
    @SerializedName("open_issues_count")
    var openIssuesCount: Int = 0,

    @ColumnInfo(name = "description")
    @NotNull
    @SerializedName("description")
    var description: String="",

    @ColumnInfo(name = "createdAt")
    @Nullable
    @SerializedName("created_at")
    var createdAt: String = "",

    @ColumnInfo(name = "watchers")
    @Nullable
    @SerializedName("watchers")
    var watchers: Int = 0,

    @ColumnInfo(name = "keysUrl")
    @Nullable
    @SerializedName("keys_url")
    var keysUrl: String = "",

    @ColumnInfo(name = "deploymentsUrl")
    @Nullable
    @SerializedName("deployments_url")
    var deploymentsUrl: String = "",

    @ColumnInfo(name = "hasProjects")
    @Nullable
    @SerializedName("has_projects")
    var hasProjects: Boolean = false,

    @ColumnInfo(name = "archived")
    @Nullable
    @SerializedName("archived")
    var archived: Boolean = false,

    @ColumnInfo(name = "hasWiki")
    @Nullable
    @SerializedName("has_wiki")
    var hasWiki: Boolean = false,

    @ColumnInfo(name = "updatedAt")
    @Nullable
    @SerializedName("updated_at")
    var updatedAt: String = "",

    @ColumnInfo(name = "commentsUrl")
    @Nullable
    @SerializedName("comments_url")
    var commentsUrl: String = "",

    @ColumnInfo(name = "stargazersUrl")
    @Nullable
    @SerializedName("stargazers_url")
    var stargazersUrl: String = "",

    @ColumnInfo(name = "disabled")
    @Nullable
    @SerializedName("disabled")
    var disabled: Boolean = false,

    @ColumnInfo(name = "gitUrl")
    @Nullable
    @SerializedName("git_url")
    var gitUrl: String = "",

    @ColumnInfo(name = "hasPages")
    @Nullable
    @SerializedName("has_pages")
    var hasPages: Boolean = false,

    @ColumnInfo(name = "commitsUrl")
    @Nullable
    @SerializedName("commits_url")
    var commitsUrl: String = "",

    @ColumnInfo(name = "compareUrl")
    @Nullable
    @SerializedName("compare_url")
    var compareUrl: String = "",

    @ColumnInfo(name = "gitCommitsUrl")
    @Nullable
    @SerializedName("git_commits_url")
    var gitCommitsUrl: String = "",

    @ColumnInfo(name = "blobsUrl")
    @Nullable
    @SerializedName("blobs_url")
    var blobsUrl: String = "",

    @ColumnInfo(name = "gitTagsUrl")
    @Nullable
    @SerializedName("git_tags_url")
    var gitTagsUrl: String = "",

    @ColumnInfo(name = "mergesUrl")
    @Nullable
    @SerializedName("merges_url")
    var mergesUrl: String = "",

    @ColumnInfo(name = "downloadsUrl")
    @Nullable
    @SerializedName("downloads_url")
    var downloadsUrl: String = "",

    @ColumnInfo(name = "hasIssues")
    @Nullable
    @SerializedName("has_issues")
    var hasIssues: Boolean = false,

    @ColumnInfo(name = "url")
    @Nullable
    @SerializedName("url")
    var url: String = "",

    @ColumnInfo(name = "contentsUrl")
    @Nullable
    @SerializedName("contents_url")
    var contentsUrl: String = "",

    @ColumnInfo(name = "mirrorUrl")
    @Nullable
    @SerializedName("mirror_url")
    var mirrorUrl: String = "",

    @ColumnInfo(name = "milestones_url")
    @Nullable
    @SerializedName("milestones_url")
    var milestonesUrl: String = "",

    @ColumnInfo(name = "teamsUrl")
    @Nullable
    @SerializedName("teams_url")
    var teamsUrl: String = "",

    @ColumnInfo(name = "fork")
    @Nullable
    @SerializedName("fork")
    var fork: Boolean = false,

    @ColumnInfo(name = "issuesUrl")
    @Nullable
    @SerializedName("issues_url")
    var issuesUrl: String = "",

    @ColumnInfo(name = "eventsUrl")
    @Nullable
    @SerializedName("events_url")
    var eventsUrl: String = "",

    @ColumnInfo(name = "issueEventsUrl")
    @Nullable
    @SerializedName("issue_events_url")
    var issueEventsUrl: String = "",

    @ColumnInfo(name = "assigneesUrl")
    @Nullable
    @SerializedName("assignees_url")
    var assigneesUrl: String = "",

    @ColumnInfo(name = "openIssues")
    @Nullable
    @SerializedName("open_issues")
    var openIssues: Int = 0,

    @ColumnInfo(name = "watchersCount")
    @Nullable
    @SerializedName("watchers_count")
    var watchersCount: Int = 0,

    @ColumnInfo(name = "nodeId")
    @Nullable
    @SerializedName("node_id")
    var nodeId: String = "",

    @ColumnInfo(name = "homepage")
    @Nullable
    @SerializedName("homepage")
    var homepage: String = "",

    @ColumnInfo(name = "forksCount")
    @Nullable
    @SerializedName("forks_count")
    var forksCount: Int = 0
)


@Dao
interface Wishes : BaseDao<Repo> {

    @Query("SELECT * FROM repo")
    fun getAll(): List<Repo>

    @Query("DELETE FROM repo")
    fun deleteAll()

}