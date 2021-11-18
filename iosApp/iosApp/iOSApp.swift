import SwiftUI
import shared

@main
struct iOSApp: App {
    
    private let useCasesModule = UseCasesModule()
    private let remoteDataModule = RemoteDataModule()
    private let localDataModule = LocalDataModule()
    
	var body: some Scene {
		WindowGroup {
			RecipeListView()
		}
	}
}
