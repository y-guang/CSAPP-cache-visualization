#include <stdio.h>

int log_2(int x) {
  int retVal = 0;

  for (retVal = 0; x > 0; x = x >> 1) {
    if (x & 1 == 1) {
      // find leading 1
      if (x == 1) {
        return retVal;
      }
      // not 2^n
      return -1;
    }
    retVal++;
  }
  // cannot find leading 1
  return -1;
}

void output_addr_format(int CT_len, int CI_len, int CO_len) {
  int i;
  printf("the format of a physical address:\n");
  for (i = CT_len + CI_len + CO_len - 1; i >= 0; i--) {
    printf("%d\t", i);
  }
  printf("\n");
  for (i = 0; i < CT_len; i++) {
    printf("CT\t");
  }
  for (i = 0; i < CI_len; i++) {
    printf("CI\t");
  }
  for (i = 0; i < CO_len; i++) {
    printf("CO\t");
  }
  printf("\n");
  printf(
      "CO The block offset within the cache line\n"
      "CI The cache index\n"
      "CT The cache tag\n");
  printf("\n");
}

void output_addr_bits(int addr, int addr_wide) {
  printf("Physical address format\n");
  int a;
  for (a = addr_wide - 1; a >= 0; a--) {
    printf("%d\t", a);
  }
  printf("\n");
  for (a = 1 << (addr_wide - 1); a > 0; a = a >> 1) {
    printf("%d\t", (addr & a) > 0 ? 1 : 0);
  }
  printf("\n");
  printf("\n");
}

void output_mem_ref(int phy_addr, int CT_len, int CI_len, int CO_len) {
  printf("Physical memory reference:\n");
  int CO, CI, CT;
  CO = (~(~0u << CO_len)) & phy_addr;
  phy_addr = phy_addr >> CO_len;
  CI = (~(~0u << CI_len)) & phy_addr;
  phy_addr = phy_addr >> CI_len;
  CT = (~(~0u << CT_len)) & phy_addr;
  printf("\tCache Offset (CO): \t0x%X\n", CO);
  printf("\tCache Index (CI): \t0x%X\n", CI);
  printf("\tCache Tag (CT): \t0x%X\n", CT);
  printf("\n");
}

int main(int argc, char const *argv[]) {
  int max_index, max_byte, addr_wide, CO_len, CI_len, CT_len, phy_addr;

  printf("Physical addresses wide:\n");
  scanf("%d", &addr_wide);
  if (addr_wide < 0 || addr_wide > 64) {
    printf("invalid\n");
  }

  printf("enter the max index, dec:\n");
  scanf("%d", &max_index);
  CI_len = log_2(max_index + 1);
  if (CI_len < 0) {
    printf("invalid\n");
    return -1;
  }

  printf("enter the max byte_i, dec:\n");
  scanf("%d", &max_byte);
  CO_len = log_2(max_byte + 1);
  if (CO_len < 0) {
    printf("invalid\n");
    return -1;
  }

  CT_len = addr_wide - CO_len - CI_len;

  output_addr_format(CT_len, CI_len, CO_len);

  printf("enter the Physical address without 0x\n");
  scanf("%x", &phy_addr);
  output_addr_bits(phy_addr, addr_wide);

  output_mem_ref(phy_addr, CT_len, CI_len, CO_len);
  
  getch();
  return 0;
}
