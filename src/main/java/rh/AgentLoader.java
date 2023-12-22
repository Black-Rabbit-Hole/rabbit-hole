package rh;

import com.sun.tools.attach.VirtualMachine;

final class AgentLoader implements Loader {

    public static final String CONST_PATH =
            "C:\\Users\\noname\\IdeaProjects\\rabbit-hole\\cmake-build-release-visual-studio\\Release\\rabbit-hole.dll";

    @Override
    public void load() throws Exception {
        /// -Djdk.attach.allowAttachSelf=true
        //System.setProperty("jdk.attach.allowAttachSelf", "true");
       // VM.setSavedProperty("jdk.attach.allowAttachSelf", "true");
        final var current = ProcessHandle.current();
        final var pid = current.pid();
        final var pidS = String.valueOf(pid);
        final var attach = VirtualMachine.attach(pidS);
       // attach.loadAgentPath(CONST_PATH);
        System.load(CONST_PATH);
    }
}
