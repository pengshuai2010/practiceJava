import os
import subprocess
def run(cmd, logfile):
    p = subprocess.Popen(cmd, shell=True, universal_newlines=True, stdout=logfile)
    ret_code = p.wait()
    logfile.flush()
    return ret_code
if __name__ == '__main__':
    os.chdir('../../bin/')
    prog = 'java'
    java_prog = 'graphAlgorithms.RandomMST'
    dis_types_list = ['-uniform', '-square', '-cube']
#     num_vertices_list = [16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192]
    num_vertices_list = [16, 32]
    num_trial = 10
    logfile = open('log.txt', 'w')
    for dis_type in dis_types_list:
        print dis_type
        logfile.write(dis_type + '\n')
        logfile.flush()
        for num_vertices in num_vertices_list:
            cmd = [prog, java_prog, dis_type, str(num_vertices), str(num_trial)]
            cmd = " ".join(cmd)
            print cmd
            run(cmd, logfile)
    logfile.close()
        