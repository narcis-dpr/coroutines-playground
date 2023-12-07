package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import kotlin.concurrent.thread

fun loadContributorsBackground(
    service: GitHubService,
    requestData: RequestData,
    updateResult: (List<User>) -> Unit
) {
    thread {
        updateResult(loadContributorsBlocking(service, requestData))
    }
}