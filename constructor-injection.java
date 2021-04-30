// Main way to use depedency injection
// Usually you would inject some kind of service.
class ResumeService {}

class InterviewSystem {
  // The class cannot be initialized without the dependency
  private _ResumeService: ResumeService;

  constructor(aResumeService: ResumeService) {
    // if (!aResumeService) {
    //   throw new Error('Null parameter goes against the DI pattern')
    // }
    // Proper way is to use a Guard Pattern, prevent null from being passed.
    CheckNeitherNullNorUndefined(aResumeService);
    this._ResumeService = aResumeService;
  }
}
